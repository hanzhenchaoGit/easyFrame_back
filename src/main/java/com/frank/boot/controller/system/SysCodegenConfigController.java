package com.frank.boot.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.annotation.Export;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.service.system.SysDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysCodegenConfigService;
import com.frank.boot.domain.system.SysCodegenConfig;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;

/**
 * system Controller
 * @author frank
 * @since 2018-06-14
 */
@RestController
@RequestMapping("/system/sysCodegenConfig")
public class SysCodegenConfigController extends BaseController {
    @Autowired
    public SysCodegenConfigService iSysCodegenConfigService;
    @Autowired
    public SysDatasourceService iSysDatasourceService;
//    @Autowired
//    public MpGenerator mpGenerator;
    @PostMapping("/addSysCodegenConfig")
    public ResultData add(@RequestBody SysCodegenConfig iSysCodegenConfig) {
        //判断唯一字段是否为空 空则进行插入操作 非空则根据唯一条件进行更新 以下需自行实现
//        iSysCodegenConfigService.(iSysCodegenConfig);
        return new ResultData();
    }

    @PostMapping("/getSysCodegenConfigByPager")
    @Export("9baecc60-6537-43e4-9f68-141c2be3c7ba")
    public ResultData getSysCodegenConfigListByPager(@RequestBody SysCodegenConfig sysCodegenConfig) throws PagerException {
        QueryWrapper<SysCodegenConfig> query = new QueryWrapper<>();
        return new ResultData(iSysCodegenConfigService.page(sysCodegenConfig.getPage(),query));
    }

    @GetMapping("/delSysCodegenConfig")
    public ResultData del(@RequestParam Integer id) {
        iSysCodegenConfigService.removeById(id);
        return new ResultData();
    }

//    @PostMapping("/generatorCode")
//    public ResultData generator(@RequestBody List<SysCodegenConfig> sysCodegenConfigs){
//        for (SysCodegenConfig config:sysCodegenConfigs ) {
//            if(config.getDatasourceId() == 1){
//                config.setSysDatasource(mpGenerator.getDefaultDataSource());
//            }else {
//                config.setSysDatasource(iSysDatasourceService.selectById(config.getDatasourceId()));
//            }
//            MpGenerator.generateByTables("com.frank.boot",config);
//        }
//        return new ResultData();
//    }

    /**
     * <p>
     *  前端控制器
     * </p>
     *
     * @author jobob
     * @since 2019-03-07
     */
    @RestController
    @RequestMapping("/system/sys-infobase-type")
    public static class SysInfobaseTypeController extends BaseController {

    }
}

