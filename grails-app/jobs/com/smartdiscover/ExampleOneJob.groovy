package com.smartdiscover

import org.quartz.JobExecutionContext

class ExampleOneJob {

    static triggers = {
        //second, minute, hour, day of month, month, day of week, year
        cron name: 'exampleOneJob', cronExpression: "0 0/5 * ? * *"
    }

    def execute(JobExecutionContext context) {
        log.info(context.fireInstanceId)
        context.put("batchId", 10L)
    }

}
