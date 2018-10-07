package com.frank.boot.controller.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.user.SysGlobalsqllogService;
import com.frank.boot.domain.user.SysGlobalsqllog;
/**
 * user Controller
 * @author frank
 * @since 2018-08-02
 */

@RestController
@RequestMapping("/user")
public class SysGlobalsqllogController extends BaseController{
    @Autowired
    public SysGlobalsqllogService iSysGlobalsqllogService;

    @GetMapping("/getSysGlobalsqllogByPager")
    public ResultData getSysGlobalsqllogListByPager() throws PagerException {
        EntityWrapper<SysGlobalsqllog> query = new EntityWrapper<>();
        if(!StringUtils.isEmpty(getString("username"))){
          query.like("username",getString("username"));
        }
        if(!StringUtils.isEmpty(getString("userid"))){
          query.like("userid",getString("userid"));
        }
        return new ResultData(iSysGlobalsqllogService.selectPage(getPager(),query),getPager());
    }
}

