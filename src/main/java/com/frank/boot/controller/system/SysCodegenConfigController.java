package com.frank.boot.controller.system;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.annotation.Export;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.service.system.SysDatasourceService;
import com.frank.boot.utils.MpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysCodegenConfigService;
import com.frank.boot.domain.system.SysCodegenConfig;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;

import java.util.List;

/**
 * system Controller
 * @author frank
 * @since 2018-06-14
 */
@RestController
@RequestMapping("/system")
public class SysCodegenConfigController extends BaseController {
    @Autowired
    public SysCodegenConfigService iSysCodegenConfigService;
    @Autowired
    public SysDatasourceService iSysDatasourceService;
    @Autowired
    public MpGenerator mpGenerator;
    @PostMapping("/addSysCodegenConfig")
    public ResultData add(@RequestBody SysCodegenConfig iSysCodegenConfig) {
        //判断唯一字段是否为空 空则进行插入操作 非空则根据唯一条件进行更新 以下需自行实现
        iSysCodegenConfigService.insertOrUpdate(iSysCodegenConfig);
        return new ResultData();
    }

    @GetMapping("/getSysCodegenConfigByPager")
    @Export("9baecc60-6537-43e4-9f68-141c2be3c7ba")
    public ResultData getSysCodegenConfigListByPager() throws PagerException {
        EntityWrapper<SysCodegenConfig> query = new EntityWrapper<>();
        return new ResultData(iSysCodegenConfigService.selectPage(getPager(),query),getPager());
    }

    @GetMapping("/delSysCodegenConfig")
    public ResultData del(@RequestParam Integer id) {
        iSysCodegenConfigService.deleteById(id);
        return new ResultData();
    }

    @PostMapping("/generatorCode")
    public ResultData generator(@RequestBody List<SysCodegenConfig> sysCodegenConfigs){
        for (SysCodegenConfig config:sysCodegenConfigs ) {
            if(config.getDatasourceId() == 1){
                config.setSysDatasource(mpGenerator.getDefaultDataSource());
            }else {
                config.setSysDatasource(iSysDatasourceService.selectById(config.getDatasourceId()));
            }
            MpGenerator.generateByTables("com.frank.boot",config);
        }
        return new ResultData();
    }
}

