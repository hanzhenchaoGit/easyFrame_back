package com.frank.boot.utils;

import com.frank.boot.domain.system.SysTask;
import com.frank.boot.exception.SystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;


/**
 * 为方便起见 job的key group与trigger的key group保持一致
 */
@Component
public class QuartzUtils {
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;
  private static final Logger logger = LogManager.getLogger(QuartzUtils.class);
  private Scheduler getScheduler() {
        return schedulerFactoryBean.getScheduler();
    }
    /**
     * 初始化任务调度
     * @author frank
     */
    @SuppressWarnings("unchecked")
    public void initJob(SysTask job, Class cls) throws SystemException {
      logger.info("初始化任务调度");
      try {
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getTaskName(), job.getTaskGroup());
        CronTrigger trigger = (CronTrigger) getScheduler().getTrigger(triggerKey);
        if (null == trigger) {
          addJob(job);
        }
      } catch (Exception e) {
        logger.error("初始化任务调度异常！" + e.getMessage(), e);
        throw new SystemException("初始化任务调度异常！" + e.getMessage());
      }
    }

    /**
     * 向任务调度中添加定时任务
     * @param job 定时任务信息
     * @author frank
     */
    @SuppressWarnings("unchecked")
    public void addJob(SysTask job) throws SystemException {
      logger.info("向任务调度中添加定时任务");
      try {
        JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(job.getJobClass()))
          .withIdentity(job.getTaskName(), job.getTaskGroup()).build();
        jobDetail.getJobDataMap().put(job.getTaskName(), job);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCorn());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getTaskName(), job.getTaskGroup())
          .withSchedule(scheduleBuilder).build();
        getScheduler().scheduleJob(jobDetail, trigger);
      } catch (Exception e) {
        logger.error("向任务调度中添加定时任务异常！" + e.getMessage(), e);
        throw new SystemException("向任务调度中添加定时任务异常！"+e.getMessage());
      }
    }

    /**
     * 立即运行定时任务
     * @param job 定时任务信息
     * @author frank
     */
    public void runJob(SysTask job) throws SystemException {
      logger.info("立即运行任务调度中的定时任务");
      try {
        if (null == job) {
          logger.info("定时任务信息为空，无法立即运行");
          throw new SystemException("定时任务信息为空，无法立即运行");
        }
        JobKey jobKey = JobKey.jobKey(job.getTaskName(), job.getTaskGroup());
        if(null == jobKey){
          logger.info("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予立即运行！");
          throw new SystemException("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予立即运行！");
        }
        getScheduler().triggerJob(jobKey);
      } catch (Exception e) {
        logger.error("立即运行任务调度中的定时任务异常！" + e.getMessage(), e);
        throw new SystemException("立即运行任务调度中的定时任务异常！" + e.getMessage());
      }
    }

    /**
     * 修改任务调度中的定时任务
     * @param job 定时任务信息
     * @author frank
     */
    public void updateSysTask(SysTask job) throws SystemException {
      this.deleteJob(job);
      this.addJob(job);
    }

    /**
     * 暂停任务调度中的定时任务
     * @param job 定时任务信息
     * @author frank
     */
    public void pauseJob(SysTask job) throws SystemException {
      logger.info("暂停任务调度中的定时任务");
      try {
        if (null == job) {
          logger.info("暂停调度任务参数不正常！");
          throw new SystemException("暂停调度任务参数不正常！");
        }
        JobKey jobKey = JobKey.jobKey(job.getTaskName(), job.getTaskGroup());
        if(null == jobKey){
          logger.info("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予进行暂停！");
          throw new SystemException("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予进行暂停！");
        }
        getScheduler().pauseJob(jobKey);
      } catch (Exception e) {
        logger.error("暂停任务调度中的定时任务异常！" + e.getMessage(), e);
        throw new SystemException("暂停任务调度中的定时任务异常！" + e.getMessage());
      }
    }

    /**
     * 暂停任务调度中的所有定时任务
     */
    public void pauseAll() throws SystemException {
        logger.info("暂停任务调度中的所有定时任务");
        try {
            getScheduler().pauseAll();
        } catch (SchedulerException e) {
          logger.error("暂停所有定时任务发生异常！ "+ e.getMessage(), e);
          throw new SystemException("暂停所有定时任务发生异常！ "+ e.getMessage());
        }
    }
    /**
     * 恢复任务调度中的定时任务
     * @param job 定时任务信息
     * @author frank
     */
    public void resumeJob(SysTask job) throws SystemException {
      logger.info("恢复任务调度中的定时任务");
      try {
        if (null == job) {
          logger.info("恢复调度任务参数不正常！");
          return;
        }
        JobKey jobKey = JobKey.jobKey(job.getTaskName(), job.getTaskGroup());
        if(null == jobKey){
          logger.info("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予进行恢复！");
          throw new SystemException("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予进行恢复！");
        }
        getScheduler().resumeJob(jobKey);
      } catch (Exception e) {
        logger.error("恢复任务调度中的定时任务异常！" + e.getMessage(), e);
        throw new SystemException("恢复任务调度中的定时任务异常！" + e.getMessage());
      }
    }
    /**
     * 暂停任务调度中的所有定时任务
     */
    public void resumeAll() throws SystemException {
        logger.info("恢复调度中的所有定时任务");
        try {
            getScheduler().resumeAll();
        } catch (SchedulerException e) {
          logger.error("恢复所有定时任务发生异常！ "+ e.getMessage(), e);
          throw new SystemException("恢复所有定时任务发生异常！ "+ e.getMessage());
        }
    }
    /**
     * 删除任务调度中的定时任务
     * @param job 定时任务信息
     * @author frank
     */
    public void deleteJob(SysTask job) throws SystemException {
      logger.info("删除任务调度中的定时任务");
      try {
        if (null == job) {
          logger.info("删除调度任务参数不正常！");
          return;
        }
        JobKey jobKey = JobKey.jobKey(job.getTaskName(), job.getTaskGroup());
        if(null == jobKey){
          logger.info("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予进行删除！");
          throw new SystemException("任务调度中不存在[" + job.getTaskName() + "]定时任务，不予进行删除！");
        }
        getScheduler().deleteJob(jobKey);
      } catch (Exception e) {
        logger.error("删除任务调度中的定时任务异常！" + e.getMessage(), e);
        throw new SystemException("删除任务调度中的定时任务异常！" + e.getMessage());
      }
    }

    /**
     * 删除任务调度定时器
     * @param triggerKey
     * @author frank
     */
    public void deleteJob(TriggerKey triggerKey){
      logger.info("删除任务调度定时器");
      try {
        if(null == triggerKey){
          logger.info("停止任务定时器参数不正常，不予进行停止！");
          return;
        }
        logger.info("停止任务定时器");
        getScheduler().pauseTrigger(triggerKey);
        getScheduler().unscheduleJob(triggerKey);
      } catch (Exception e) {
        logger.info("删除任务调度定时器异常！" + e.getMessage() ,e);
      }
    }

    public String getJobStatus(String group, String name) throws SchedulerException {
      TriggerKey triggerKey = new TriggerKey(name,group);
      Trigger.TriggerState state = getScheduler().getTriggerState(triggerKey);
      return state.name();
    }
}
