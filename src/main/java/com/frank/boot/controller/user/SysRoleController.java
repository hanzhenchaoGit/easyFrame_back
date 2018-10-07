package com.frank.boot.controller.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.user.SysRoleService;
import com.frank.boot.domain.user.SysRole;
import org.apache.commons.lang.StringUtils;
import com.frank.boot.domain.system.ResultData;

/**
 * user Controller
 * @author frank
 * @since 2018-06-19
 */

@RestController
@RequestMapping("/user")
public class SysRoleController extends BaseController{
    @Autowired
    public SysRoleService iSysRoleService;

    @PostMapping("/addSysRole")
    public ResultData add(@RequestBody SysRole iSysRole) {
        iSysRoleService.insertOrUpdate(iSysRole);
        return new ResultData();
    }
    @GetMapping("/getSysRoleList")
    public ResultData getSysRoleList(){
        EntityWrapper<SysRole> query = new EntityWrapper<>();
        if(!StringUtils.isEmpty(getString("id"))){
          query.eq("id",getString("id"));
        }

        return new ResultData(iSysRoleService.selectList(query));
    }
    @GetMapping("/delSysRole")
    public ResultData del(@RequestParam Integer id) {
        iSysRoleService.deleteById(id);
        return new ResultData();
    }
    }

