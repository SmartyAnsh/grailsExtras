package com.smartdiscover


import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException
import org.quartz.listeners.JobListenerSupport

class JobExecutionListener extends JobListenerSupport {

    public static final String NAME = "jobExecutionListener";

    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Before job execution.
     */
    public void jobToBeExecuted(JobExecutionContext context) {
        getLog().info("${context.getJobDetail().getKey().getName()} with FireInstanceId #${context.getFireInstanceId()} started running.");
    }

    /**
     * After job execution.
     */
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException exception) {
        getLog().info("${context.getJobDetail().getKey().getName()} with FireInstanceId #${context.getFireInstanceId()} finished running.");
        JobExecutionLog jobExecutionLog = new JobExecutionLog();
        jobExecutionLog.jobName = context.getJobDetail().getKey().getName()
        jobExecutionLog.jobGroup = context.getJobDetail().getKey().getGroup()
        jobExecutionLog.fireTime = context.getFireTime()
        jobExecutionLog.scheduledFireTime = context.getScheduledFireTime()
        jobExecutionLog.previousFireTime = context.getPreviousFireTime()
        jobExecutionLog.nextFireTime = context.getNextFireTime()
        jobExecutionLog.jobRunTime = context.getJobRunTime()
        jobExecutionLog.fireInstanceId = context.getFireInstanceId()
        jobExecutionLog.result = context.getResult()
        jobExecutionLog.isConcurrentExecutionDisallowed = context.getJobDetail().isConcurrentExectionDisallowed()
        jobExecutionLog.batchId = context.get("batchId")
        jobExecutionLog.exception = exception?.getMessage()
        jobExecutionLog.save();
    }
}
