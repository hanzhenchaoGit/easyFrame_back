package com.frank.boot.controller.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
        iSysPermissionService.insertOrUpdate(iSysPermission);
        return new ResultData();
    }
    @GetMapping("/getSysPermissionList")
    public ResultData getSysPermissionList(){
        EntityWrapper<SysPermission> query = new EntityWrapper<>();
        return new ResultData(iSysPermissionService.selectList(query));
    }
    @GetMapping("/delSysPermission")
    public ResultData del(@RequestParam Integer id) {
        iSysPermissionService.deleteById(id);
        return new ResultData();
    }
}
