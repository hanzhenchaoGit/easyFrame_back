package com.frank.boot.controller.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.user.SysUserFrontlog;
import com.frank.boot.exception.PagerException;
import com.frank.boot.service.user.SysUserFrontlogService;
/**
 * user Controller
 * @author frank
 * @since 2018-08-02
 */

@RestController
@RequestMapping("/user")
public class SysUserFrontlogController extends BaseController{
    @Autowired
    public SysUserFrontlogService iSysUserFrontlogService;
    @PostMapping("/addSysUserFrontlog")
    public ResultData addSysUserFrontlog(@RequestBody SysUserFrontlog frontLog) throws PagerException {
//        SysUser user = this.getCurrentUser();
//        frontLog.setUserid(user.getUserName());
//        frontLog.setUsername(user.getName());
//        frontLog.setIpaddress(NetUtils.getIpAddress(request));
//    	iSysUserFrontlogService.insert(frontLog);
        return new ResultData();
    }
    
    @GetMapping("/getSysUserFrontlogByPager")
    public ResultData getSysUserFrontlogListByPager() throws PagerException {
        EntityWrapper<SysUserFrontlog> query = new EntityWrapper<>();
        if(!StringUtils.isEmpty(getString("username"))){
          query.like("username",getString("username"));
        }
        return new ResultData(iSysUserFrontlogService.selectPage(getPager(),query),getPager());
    }
}

