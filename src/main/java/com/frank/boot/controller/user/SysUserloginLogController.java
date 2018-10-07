package com.frank.boot.controller.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.user.SysUserloginLogService;
import com.frank.boot.domain.user.SysUserloginLog;
/**
 * user Controller
 * @author frank
 * @since 2018-08-03
 */

@RestController
@RequestMapping("/user")
public class SysUserloginLogController extends BaseController{
    @Autowired
    public SysUserloginLogService iSysUserloginLogService;

    @PostMapping("/addSysUserloginLog")
    public ResultData add(@RequestBody SysUserloginLog iSysUserloginLog) {
//        iSysUserloginLogService.insertOrUpdate(iSysUserloginLog);
        return new ResultData();
    }
    @GetMapping("/getSysUserloginLogByPager")
    public ResultData getSysUserloginLogListByPager() throws PagerException {
        EntityWrapper<SysUserloginLog> query = new EntityWrapper<>();
        if(!StringUtils.isEmpty(getString("username"))){
          query.like("username",getString("username"));
        }
        return new ResultData(iSysUserloginLogService.selectPage(getPager(),query),getPager());
    }
}

