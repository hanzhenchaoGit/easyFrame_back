package com.frank.boot.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.system.SysInfobaseDetail;
import com.frank.boot.domain.system.SysInfobaseType;
import com.frank.boot.service.system.ISysInfobaseDetailService;
import com.frank.boot.service.system.ISysInfobaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-03-07
 */
@RestController
@RequestMapping("/system/sysnIfobaseDetail")
public class SysInfobaseDetailController extends BaseController {
    @Autowired
    ISysInfobaseDetailService iSysInfobaseDetailService;
    @PostMapping("/add")
    public ResultData add(@RequestBody SysInfobaseDetail sysInfobaseDetail) {
        iSysInfobaseDetailService.save(sysInfobaseDetail);
        return new ResultData();
    }
    @PostMapping("/getList")
    public ResultData getList(@RequestBody SysInfobaseDetail sysInfobaseDetail) {
        QueryWrapper<SysInfobaseDetail> query = new QueryWrapper<>();
        query.eq("type_code", sysInfobaseDetail.getTypeCode());
        return new ResultData(iSysInfobaseDetailService.page(sysInfobaseDetail.getPage(),query));
    }
}
