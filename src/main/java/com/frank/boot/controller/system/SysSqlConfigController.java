package com.frank.boot.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.annotation.Export;
import com.frank.boot.controller.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysSqlConfigService;
import com.frank.boot.domain.system.SysSqlConfig;
import org.apache.commons.lang.StringUtils;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * system Controller
 * @author frank
 * @since 2018-06-14
 */

@RestController
@RequestMapping("/system")
@CacheConfig(cacheNames = "userTokenCache")
public class SysSqlConfigController extends BaseController {
    @Autowired
    public SysSqlConfigService iSysSqlConfigService;
    @Autowired
    WebApplicationContext webApplicationContext;
    @PostMapping("/addSysSqlConfig")
    public ResultData add(@RequestBody SysSqlConfig iSysSqlConfig) {
        ResultData resultData = new ResultData();
        if (iSysSqlConfig.getId() == null) {
            iSysSqlConfig.setCreatetime(new Date());
            iSysSqlConfig.setCreateuserid(getCurrentUser().getUserName());
            iSysSqlConfig.setUuid(UUID.randomUUID().toString());
        } else {
            iSysSqlConfig.setUpdatetime(new Date());
            iSysSqlConfig.setUpdateuserid(getCurrentUser().getUserName());
        }
        iSysSqlConfigService.saveOrUpdate(iSysSqlConfig);
        resultData.setData(iSysSqlConfig.getUuid());
        return resultData;
    }

    @Export("12b4baee-672d-4704-9df6-5381bae63cd0")
    @GetMapping(value = "/getSysSqlConfigByPager")
    public ResultData getSysSqlConfigListByPager() throws PagerException {
//        System.out.println(webApplicationContext);
//        //获取所有的RequestMapping
//        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(webApplicationContext,
//                HandlerMapping.class, true, false);
        QueryWrapper<SysSqlConfig> query = new QueryWrapper<>();
        if (!StringUtils.isEmpty(getString("name"))) {
            query.like("name", getString("name"));
        }
        if (!StringUtils.isEmpty(getString("id"))) {
            query.eq("id", getString("id"));
        }
        iSysSqlConfigService.listMaps(null);
        iSysSqlConfigService.page(getPager(), query);
        return new ResultData(iSysSqlConfigService.page(getPager(), query), getPager());
    }

    @GetMapping("/getSysSqlConfigList")
    public ResultData getSysSqlConfigList() {
        QueryWrapper<SysSqlConfig> query = new QueryWrapper<>();
        if (!StringUtils.isEmpty(getString("name"))) {
            query.like("name", getString("name"));
        }
        if (!StringUtils.isEmpty(getString("id"))) {
            query.eq("id", getString("id"));
        }
        return new ResultData(iSysSqlConfigService.list(query));
    }

    @GetMapping("/delSysSqlConfig")
    public ResultData del(@RequestParam Integer id) {
        iSysSqlConfigService.removeById(id);
        return new ResultData();
    }
}

