package com.frank.boot.controller.system;

import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysMenusService;
import com.frank.boot.domain.system.SysMenus;

/**
 * system Controller
 * @author frank
 * @since 2018-06-25
 */

@RestController
@RequestMapping("/system")
public class SysMenusController extends BaseController{
    @Autowired
    public SysMenusService iSysMenusService;

    @PostMapping("/addSysMenus")
    public ResultData add(@RequestBody SysMenus iSysMenus) {
        iSysMenusService.insertOrUpdate(iSysMenus);
        return new ResultData();
    }
    @GetMapping("/getSysMenusList")
    public ResultData getSysMenusList(){
        return new ResultData(iSysMenusService.getMenusByFileter(0,""));
    }
    @GetMapping("/delSysMenus")
    public ResultData del(@RequestParam Integer id) {
        iSysMenusService.deleteById(id);
        return new ResultData();
    }


}

