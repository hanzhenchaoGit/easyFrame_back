package com.frank.boot.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.annotation.Export;
import com.frank.boot.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysExportConfigService;
import com.frank.boot.domain.system.SysExportConfig;
import org.apache.commons.lang.StringUtils;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;
import com.frank.boot.exception.SystemException;

import java.util.UUID;

/**
 * system Controller
 * @author frank
 * @since 2018-06-19
 */

@RestController
@RequestMapping("/system")
public class SysExportConfigController extends BaseController{
    @Autowired
    public SysExportConfigService iSysExportConfigService;

    @PostMapping("/addSysExportConfig")
    public ResultData add(@RequestBody SysExportConfig iSysExportConfig) throws SystemException {
        if(iSysExportConfig.getId()==null){
            iSysExportConfig.setUuid(UUID.randomUUID().toString());
        }
        //代理请求的导出任务存储的唯一uuid为请求的uuid
        if(iSysExportConfig.getRequestType().equals("pr")){
        	String urlPath = iSysExportConfig.getUrlPath();
        	if(urlPath.indexOf("uuid")>-1){
        		iSysExportConfig.setUuid(urlPath.substring(urlPath.indexOf("uuid")+5,urlPath.length()));
        	}else{
        		throw new SystemException("导出配置请求中未发现uuid 无法保存");
        	}
        }
        iSysExportConfigService.saveOrUpdate(iSysExportConfig);
        return new ResultData(iSysExportConfig.getUuid());
    }
    @Export("")
    @GetMapping("/getSysExportConfigByPager")
    public ResultData getSysExportConfigListByPager() throws PagerException {
        QueryWrapper<SysExportConfig> query = new QueryWrapper<>();
        if(!StringUtils.isEmpty(getString("sheet_name"))){
          query.like("sheet_name",getString("sheet_name"));
        }
        return new ResultData(iSysExportConfigService.page(getPager(),query),getPager());
    }
    @GetMapping("/delSysExportConfig")
    public ResultData del(@RequestParam Integer id) {
        iSysExportConfigService.removeById(id);
        return new ResultData();
    }
    public static void main(String[] args) {
		String path ="/system/proxyExcute?uuid=069a2a90-de27-40b9-9fed-17027eae7531";
		System.out.println(path.substring(path.indexOf("uuid")+5,path.length()));
    }
    }

