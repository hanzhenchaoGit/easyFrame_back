package com.frank.boot.task;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DemoJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getJobDetail().getJobDataMap().toString());
        System.out.println("jobKey:  "+context.getJobDetail().getKey()+"  "+context.getJobDetail().getDescription()+" trigger"+
        context.getTrigger().getKey()+"  group"+ context.getTrigger().getKey().getName()+"  group2 "+context.getTrigger().getKey().getGroup());
    }
}
