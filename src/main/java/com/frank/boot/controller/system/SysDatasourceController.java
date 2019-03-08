//package com.frank.boot.controller.system;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.frank.boot.controller.base.BaseController;
//import com.frank.boot.utils.MpGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.frank.boot.service.system.SysDatasourceService;
//import com.frank.boot.domain.system.SysDatasource;
//import com.frank.boot.domain.system.ResultData;
//import com.frank.boot.exception.PagerException;
//
//import java.util.List;
//
///**
// * system Controller
// * @author frank
// * @since 2018-06-14
// */
//@RestController
//@RequestMapping("/system")
//public class SysDatasourceController extends BaseController {
//    @Autowired
//    MpGenerator mpGenerator;
//    @Autowired
//    public SysDatasourceService iSysDatasourceService;
//    @PostMapping("/addSysDatasource")
//    public ResultData add(@RequestBody SysDatasource iSysDatasource) {
//        //判断唯一字段是否为空 空则进行插入操作 非空则根据唯一条件进行更新 以下需自行实现
//        iSysDatasourceService.saveOrUpdate(iSysDatasource);
//        return new ResultData();
//    }
//
//    @GetMapping("/getSysDatasourceById")
//    public ResultData getSysDatasourceListByPager(@RequestParam String id) throws PagerException {
//        QueryWrapper<SysDatasource> query = new QueryWrapper<>();
//        return new ResultData(iSysDatasourceService.selectById(id));
//    }
//    @GetMapping("/getSysDatasourceList")
//    public ResultData getSysDatasourceList() {
//        List<SysDatasource> result = iSysDatasourceService.selectList(null);
//        result.add(mpGenerator.getDefaultDataSource());
//        return new ResultData(result);
//    }
//
//
//    @GetMapping("/delSysDatasource")
//    public ResultData del(@RequestParam Integer id) {
//        iSysDatasourceService.removeById(id);
//        return new ResultData();
//    }
//}
//
