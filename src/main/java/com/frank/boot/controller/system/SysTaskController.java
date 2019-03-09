package com.frank.boot.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.task.QuartzLog;
import com.frank.boot.exception.PagerException;
import com.frank.boot.exception.SystemException;
import com.frank.boot.service.task.QuartzLogService;
import com.frank.boot.utils.QuartzUtils;
import org.apache.commons.lang.StringUtils;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.system.SysTaskService;
import com.frank.boot.domain.system.SysTask;
import java.util.List;
import static com.frank.boot.utils.SysContent.*;

/**
 * system Controller
 * @author frank
 * @since 2018-06-20
 */

@RestController
@RequestMapping("/system")
public class SysTaskController extends BaseController{
    Logger logger = LoggerFactory.getLogger(SysTaskController.class);
    @Autowired
    public SysTaskService iSysTaskService;
    @Autowired
    QuartzUtils quartzUtils;
    @Autowired
    QuartzLogService quartzLogService;
    @PostMapping("/addSysTask")
    public ResultData add(@RequestBody SysTask iSysTask) throws SystemException {
        iSysTaskService.saveOrUpdate(iSysTask);

        if(iSysTask.getId() == null){
            quartzUtils.addJob(iSysTask);
        }else{
            quartzUtils.updateSysTask(iSysTask);
        }
        return new ResultData();
    }

    @PostMapping("/operateSysTask")
    public ResultData operateSysTask(@RequestBody List<SysTask> iSysTasks,@RequestParam("operate") String operate) throws SystemException {
        switch (operate) {
            case QUARTZ_ADD:
                for (SysTask task : iSysTasks) {
                    quartzUtils.addJob(task);
                }
                break;
            case QUARTZ_REMOVE:
                for (SysTask task : iSysTasks) {
//                    quartzUtils.re(task);
                }
                break;
            case QUARTZ_PAUSE:
                for (SysTask task : iSysTasks) {
                    quartzUtils.pauseJob(task);
                }
                break;
            case QUARTZ_RESUME:
                for (SysTask task : iSysTasks) {
                    quartzUtils.resumeJob(task);
                }
                break;
            case QUARTZ_PAUSEALL:
                quartzUtils.pauseAll();
                break;
            case QUARTZ_RESUMEALL:
                quartzUtils.resumeAll();
                break;
        }
        return new ResultData();
    }

    @PostMapping("/getSysTaskByPager")
    public ResultData getSysTaskListByPager(@RequestBody SysTask sysTask) {
        QueryWrapper<SysTask> query = new QueryWrapper<>();
        if(!StringUtils.isEmpty(getString("name"))){
          query.like("name",getString("name"));
        }
        if(!StringUtils.isEmpty(getString("enabled"))){
          query.eq("enabled",getString("enabled"));
        }
        if(!StringUtils.isEmpty(getString("group"))){
          query.eq("group",getString("group"));
        }
        IPage<SysTask> tasks = iSysTaskService.page(sysTask.getPage(),query);
        tasks.getRecords().forEach(task -> {
            try {
                task.setState(quartzUtils.getJobStatus(task.getTaskGroup(),task.getTaskName()));
            } catch (SchedulerException e) {
                e.printStackTrace();
                logger.error("查询状态出错"+e.getMessage());
                task.setState("");
            }
        });
        return new ResultData(tasks);
    }
    @GetMapping("/delSysTask")
    public ResultData del(@RequestParam Integer id) throws SystemException {
        SysTask task = iSysTaskService.getById(id);
        quartzUtils.deleteJob(task);
        iSysTaskService.removeById(id);
        return new ResultData();
    }
    @PostMapping("/getQuartzLogs")
    public ResultData getQuartzLogs(@RequestParam String jobKey) throws PagerException {
        return new ResultData(quartzLogService.page(getPager(),new QueryWrapper<QuartzLog>().eq("jkey",jobKey)));
    }
}

