package com.frank.boot.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.SysMenus;
import com.frank.boot.service.system.SysMenusService;
import com.frank.boot.utils.SysContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.user.SysRoleService;
import com.frank.boot.domain.user.SysRole;
import org.apache.commons.lang.StringUtils;
import com.frank.boot.domain.system.ResultData;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    SysMenusService menusService;

    @PostMapping("/addSysRole")
    public ResultData add(@RequestBody SysRole iSysRole) {
        iSysRoleService.saveOrUpdate(iSysRole);
        return new ResultData();
    }
    @GetMapping("/getSysRoleList")
    public ResultData getSysRoleList(){
        QueryWrapper<SysRole> query = new QueryWrapper<>();
        if(!StringUtils.isEmpty(getString("id"))){
          query.eq("id",getString("id"));
        }

        return new ResultData(iSysRoleService.list(query));
    }
    @PostMapping("/delSysRole")
    public ResultData del(@RequestBody SysRole role) {
        iSysRoleService.removeById(role);
        ResultData result = new ResultData();
        result.setMsg(SysContent.DEL_SCCESS);
        return result;
    }

    @PostMapping("/getRoleList")
    public ResultData getRoleList(@RequestBody SysRole role){
        return new ResultData(iSysRoleService.page(role.getPage()));
    }
}

