package com.frank.boot.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysCodeService;
import com.frank.boot.domain.system.SysCode;
/**
 * system Controller
 * @author frank
 * @since 2018-09-15
 */

@RestController
@RequestMapping("/system")
public class SysCodeController extends BaseController{
    @Autowired
    public SysCodeService iSysCodeService;

    @PostMapping("/addSysCode")
    public ResultData add(@RequestBody SysCode iSysCode) {
        iSysCodeService.insertOrUpdate(iSysCode);
        return new ResultData();
    }
}

