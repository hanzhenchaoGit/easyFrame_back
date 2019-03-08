package com.frank.boot.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.system.SysInfobaseType;
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
@RequestMapping("/system/sysInfobaseType")
public class SysInfobaseTypeController extends BaseController {
    @Autowired
    ISysInfobaseTypeService iSysInfobaseTypeService;
    @PostMapping("/add")
    public ResultData add(@RequestBody SysInfobaseType sysInfobaseType) {
        iSysInfobaseTypeService.save(sysInfobaseType);
        return new ResultData();
    }
    @PostMapping("/getList")
    public ResultData getList(@RequestBody SysInfobaseType sysInfobaseType) {
        QueryWrapper<SysInfobaseType> query = new QueryWrapper<>();
        query.like("type_code", sysInfobaseType.getTypeName()).or().like("type_name", sysInfobaseType.getTypeName());
        return new ResultData(iSysInfobaseTypeService.page(sysInfobaseType.getPage(), query));
    }
}
