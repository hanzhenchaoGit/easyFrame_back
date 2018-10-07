package com.frank.boot.task.monitor;

import com.frank.boot.domain.task.QuartzLog;
import com.frank.boot.service.task.QuartzLogService;
import com.frank.boot.utils.SpringUtil;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class MonitorTriggerListener implements TriggerListener {
    
    private final static Logger logger=LoggerFactory.getLogger(MonitorTriggerListener.class);
    private ThreadLocal<QuartzLog> localLog=new ThreadLocal<>();

    /**  
     * @see org.quartz.TriggerListener#getName()    
     */
    @Override
    public String getName() {
        return "MonitorTriggerListener";
    }
    
    @Override
    public void triggerFired(Trigger arg0, JobExecutionContext jobExecutionContext) {
        QuartzLogService quartzLogService = SpringUtil.getBean(QuartzLogService.class);
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        QuartzLog quartzLog = new QuartzLog();
        quartzLog.setJclass(jobDetail.getJobClass().toString());
        quartzLog.setJstarttime(new Date());
        quartzLog.setJgroup(jobDetail.getKey().getGroup());
        quartzLog.setJkey(jobDetail.getKey().getName());
        try {
            logger.info("trigger触发{}------------",jobDetail.getJobClass());
            localLog.set(quartzLog);
        } catch (Exception e) {
            logger.error("记录job开始异常",e);
        }catch (Throwable e) {
            logger.error("记录job开始出错",e);
        }finally {
            quartzLogService.insert(quartzLog);
        }
    }
    
    /**  
     * @see org.quartz.TriggerListener#triggerMisfired(org.quartz.Trigger)    
     */
    @Override
    public void triggerMisfired(Trigger arg0) {

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        QuartzLogService quartzLogService = SpringUtil.getBean(QuartzLogService.class);
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        logger.info("trigger执行结束{}------------",jobDetail.getJobClass());
        QuartzLog quartzLog = localLog.get();
        quartzLog.setJruntime(jobExecutionContext.getJobRunTime());
        quartzLog.setIssuccess("Y");
        quartzLog.setJendtime(new Date());
        quartzLogService.insertOrUpdate(quartzLog);
    }

    @Override
    public boolean vetoJobExecution(Trigger arg0, JobExecutionContext arg1) {
        return false;
    }
}
