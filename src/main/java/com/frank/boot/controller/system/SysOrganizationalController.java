package com.frank.boot.controller.system;

import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysOrganizationalService;
import com.frank.boot.domain.system.SysOrganizational;
/**
 * system Controller
 * @author frank
 * @since 2018-07-27
 */

@RestController
@RequestMapping("/system")
public class SysOrganizationalController extends BaseController{
    @Autowired
    public SysOrganizationalService iSysOrganizationalService;

    @PostMapping("/addSysOrganizational")
    public ResultData add(@RequestBody SysOrganizational iSysOrganizational) {
        iSysOrganizationalService.insertOrUpdate(iSysOrganizational);
        return new ResultData();
    }
    @GetMapping("/delSysOrganizational")
    public ResultData del(@RequestParam Integer id) {
        iSysOrganizationalService.deleteById(id);
        return new ResultData();
    }

    @GetMapping("/getAllOrgs")
        public ResultData getAll(){
        return new ResultData(iSysOrganizationalService.getAllOrganizationalsByPid(-1));
    }
}

