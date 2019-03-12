package com.frank.boot.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.user.SysPermissionService;
import com.frank.boot.domain.user.SysPermission;
/**
 * user Controller
 * @author frank
 * @since 2018-07-31
 */

@RestController
@RequestMapping("/user")
public class SysPermissionController extends BaseController{
    @Autowired
    public SysPermissionService iSysPermissionService;

    @PostMapping("/addSysPermission")
    public ResultData add(@RequestBody SysPermission iSysPermission) {
        iSysPermissionService.saveOrUpdate(iSysPermission);
        return new ResultData();
    }
    @PostMapping("/getSysPermissionList")
    public ResultData getSysPermissionList(){
        QueryWrapper<SysPermission> query = new QueryWrapper<>();
        return new ResultData(iSysPermissionService.list(query));
    }
    @GetMapping("/delSysPermission")
    public ResultData del(@RequestParam Integer id) {
        iSysPermissionService.removeById(id);
        return new ResultData();
    }
}

