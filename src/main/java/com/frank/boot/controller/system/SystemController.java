package com.frank.boot.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.exception.PagerException;
import com.frank.boot.dao.system.CommonDao;
import com.frank.boot.domain.system.CommonPager;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.system.SysSqlConfig;
import com.frank.boot.service.system.SystemService;
import com.frank.boot.utils.SysContent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.internal.Engine;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.session.Session;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;
@Api(value="系统请求Controller",tags={"统一请求代理及日志查看"})
@RestController
@RequestMapping("/system")
public class SystemController extends BaseController {
    @Value("${logging.file}")
    String logFile;
    @Autowired
    SystemService systemService;

    private final String [] ignoalParam = {"currentPage","pageSize","orderBy","export","isPage","uuid"};
    @Autowired
    CommonDao commonDao;
    @Autowired
    RedisSessionDAO redisSessionDAO;
    @ApiOperation(value = "动态代理请求统一接口", notes = "动态代理请求统一接口")
       // sql@@if|||addSql@@if
    @GetMapping(value = "/proxyExcute")
    public ResultData proxy() throws PagerException {
        Map<String,Object> params = getRequestParamMap();
        String uuid = getString("uuid");
        
        CommonPager pager = null;

        if(params.get("currentPage") != null){
            pager = this.getPager();
        }
        Boolean hasParams = false;
        SysSqlConfig config = new SysSqlConfig();
        config.setUuid(uuid);
        EntityWrapper<SysSqlConfig> query =  new EntityWrapper<>();
        query.setEntity(config);
        config = systemService.selectOne(query);
        String content = config.getContent();
        String bodys [] = content.split("\\#\\#");
        String beforBody = bodys[0];
        String[] expres = beforBody.split("@@");
        //切分出来的表达式第一部分为主体sql语句
        String sql = expres[0];
        for (int i = 1; i < expres.length; i++) {
          String judgeBody = expres[i];
          String expression = judgeBody.split("\\|\\|\\|")[0];
          String addSql = judgeBody.split("\\|\\|\\|")[1];
          if(convertToBoolean(expression,params)){
            sql += addSql;
          }
        }
        List ignoalList = Arrays.asList(ignoalParam);
        Properties properties = new Properties();
        for(String key : params.keySet()){
            properties.setProperty(key,"'"+params.get(key)+"'");
        }

        // sql拼接逻辑
        PropertyPlaceholderHelper valuPlace = new PropertyPlaceholderHelper("#{","}");
        sql = valuPlace.replacePlaceholders(sql,properties);

        List result = new ArrayList();
        ResultData resultData =new ResultData();
//        if(pager!=null&&pager.isExport()){
//            resultData.setExport(true);
//        }
        
        if(bodys.length==2){
            sql += bodys[1];
        }
        
        if(pager != null){
            Page page = systemService.excuteSqlByPager(pager,sql,uuid);
            resultData.setData(page);
            resultData.setPager(pager);
        }else{
        	String exportType = getString("exportType");
        	if(exportType!=null){
        		CommonPager exportPager = new CommonPager<>();
        		exportPager.setExport(true);
        		resultData.setPager(exportPager);
            }
            result = systemService.excuteSql(sql,uuid);
            resultData.setData(result);
        }
        
        return resultData;
    }

    public static boolean convertToBoolean( String jexlExp, Map<String, Object> map ) {
        // 创建或检索引擎
        JexlEngine jexl = new Engine();
        // 创建一个表达式
        JexlExpression e = jexl.createExpression( jexlExp );
        // 创建上下文并添加数据
        JexlContext jc = new MapContext();
        for ( String key : map.keySet() ) {
          jc.set( key, map.get( key ) );
        }
        Object value = new Object();
        try{
        // 现在评估表达式，得到结果
            value = e.evaluate( jc );
        }catch(Exception ex) {
            return false;
        }
        return (Boolean)value;
    }

    @GetMapping("/loglists")
    public ResultData getLogsList(){
        File files = new File(getLogDir());
        String [] filenames = files.list();
        return new ResultData(filenames);
    }
    @GetMapping("/getFile")
    public ResultData getFile(@RequestParam String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(getLogDir()+"/"+name));
        String len;
        StringBuffer logStr = new StringBuffer();
        while((len=br.readLine())!=null){
            logStr.append(len).append("</br>");
        }
        br.close();
        return new ResultData(logStr);
    }

    @GetMapping("/downloadLog")
    public void downloadLog(@RequestParam String filename) throws IOException {
        File file = new File(getLogDir()+"/"+filename);
        InputStream fis = new BufferedInputStream(new FileInputStream(getLogDir()+"/"+filename));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
        response.addHeader("Content-Length", "" + file.length());
        OutputStream out = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("multipart/form-data");
        out.flush();
        out.write(buffer);
    }

    public String getLogDir(){
        return logFile.substring(0,logFile.lastIndexOf("/"));
    }

    //获取分页信息
//    public Page getPager(Map<String,Object> params) throws PagerException {
//        Page pager =  new Page();
//        if(params.get("currentPage")==null || StringUtils.isEmpty(params.get("currentPage").toString())){
//            throw new PagerException(SysContent.PAGER_NO_CURRENTPAGE);
//        } else if(params.get("pageSize")==null && StringUtils.isEmpty(params.get("pageSize").toString())){
//            throw new PagerException(SysContent.PAGER_NO_PAGESIZSE);
//        }
////        if(params.get("orderBy")!=null && !StringUtils.isEmpty(params.get("orderBy").toString())){
////            pager.setOrderBy(params.get("orderBy").toString());
////        }
//        pager.setCurrent(Integer.parseInt(params.get("currentPage").toString()));
//        pager.setSize(Integer.parseInt(params.get("pageSize").toString()));
//        Object export = params.get("export");
////        if(export != null){
////            if("Y".equals(export.toString())){
////                pager.setExport(true);
////            }
////        }
//        return pager;
//    }
    public ResultData getOnLineUsers(){
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        return null;
    }
}
