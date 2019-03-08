package com.frank.boot.aop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.annotation.Export;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.system.SysExportConfig;
import com.frank.boot.service.system.SysExportConfigService;
import com.frank.boot.utils.DateUtils;
import com.frank.boot.utils.PoiExcelUtils;
import com.frank.boot.utils.ShiroSessionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.session.Session;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import static com.frank.boot.utils.PoiExcelUtils.XLSX;

/**
 * excel导出控制切面
 * 导出生效条件：
 * 1.前端请求中带export=Y 参数 如需导出所有数据 设置pageSize = 0
 * 2.查询的service实现中需要设置导出的Sheet页的相关信息
 * 3.Controller层需要将QueryPager对象传到ResultData中便于切面进行处理
 */
@Aspect
@Component
public class ControllerInterceptor {

    private static final String EXPORT_EXECUTION = "execution(* com.frank.boot.controller..*.*(..))";

    @Autowired
            @Qualifier("export")
    SysExportConfigService sysExportConfigService;
    @Autowired
    ShiroSessionUtils sessionUtils;
    @Value("${system.upload.template}")
    String templatePath;
    
    @Pointcut(EXPORT_EXECUTION)
    public void exportAdvice(){}

    @Around("exportAdvice()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Class<?> classTarget = proceedingJoinPoint.getTarget().getClass();
        Class<?>[] par = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterTypes();
        Method objMethod = classTarget.getMethod(methodName, par);
        //获取导出注解
        Export export = objMethod.getAnnotation(Export.class);


        Object result = proceedingJoinPoint.proceed();//调用执行目标方法
        if(result instanceof ResultData){
            // 获取在线人数
            Collection<Session> sessions = sessionUtils.getActiveSessions();
            ResultData resultData = (ResultData)result;
            resultData.setUserCount(sessions.size());
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            String uuid = sra.getRequest().getParameter("uuid");
            if(resultData.getPager()!=null&&resultData.getPager().isExport()){
                if(export!=null||!StringUtils.isEmpty(uuid)){
                    QueryWrapper<SysExportConfig> QueryWrapper = new QueryWrapper();
                    QueryWrapper.eq("uuid",export!=null?export.value():uuid);
                    SysExportConfig sheetResult = sysExportConfigService.getOne(QueryWrapper);
                    if(sheetResult != null){
                    	List dataList = new ArrayList<>();
                    	if(resultData.getData() instanceof ArrayList){
                    		dataList = (ArrayList)resultData.getData();
                    	}else{
                    		 dataList = (ArrayList)((Map<String,Object>)resultData.getData()).get("items");
                    	}
                        if(dataList==null || dataList.size() == 0 ){
                            resultData.setMsg("导出数据为空");
                            return resultData;
                        }
                        sheetResult.setDataList(dataList);
                        Workbook wb = null;
                        if("N".equals(sheetResult.getIstem())){
                        	wb = PoiExcelUtils.createWorkBook(XLSX);
                        }else if("E".equals(sheetResult.getIstem())){
                        	wb = new XSSFWorkbook(templatePath+sheetResult.getTemplate());
                        }else {

                        }
                        
                        wb = PoiExcelUtils.writeDataToExcel(wb,sheetResult);
                        HttpServletResponse response = sra.getResponse();
                        response.addHeader("Content-Disposition", "attachment;filename=" + new String((sheetResult.getSheetName()+DateUtils.getCurrentDate()+".xlsx").getBytes("gb2312"), "ISO8859-1" ) );
                        OutputStream out = new BufferedOutputStream(response.getOutputStream());
                        response.setContentType("multipart/form-data");
                        wb.write(out);
                        return new ResultData();
                    }
                    return resultData;
                }else {
                    resultData.setMsg("导出失败:"+"未找到导出后台");
                }
            }else {
                return resultData;
            }
        }else{
            return result;
        }
        return result;
    }
}

