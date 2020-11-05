package com.smartdiscover

class JobExecutionLog {

    String jobName
    String jobGroup
    Date fireTime
    Date scheduledFireTime
    Date previousFireTime
    Date nextFireTime
    String fireInstanceId
    Long jobRunTime
    String result
    String exception
    boolean isConcurrentExecutionDisallowed
    Long batchId

    static constraints = {
        previousFireTime nullable: true
        nextFireTime nullable: true
        result nullable: true
        exception nullable: true
        batchId nullable: true
    }

    static mapping = {
        version false
        result type: 'text'
        exception type: 'text'
    }
}
