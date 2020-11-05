package com.smartdiscover

import org.quartz.JobExecutionContext

class ExampleTwoJob {

    static triggers = {
        //second, minute, hour, day of month, month, day of week, year
        cron name: 'exampleTwoJob', cronExpression: "0 0/6 * ? * *"
    }

    def execute(JobExecutionContext context) {
        log.info(context.fireInstanceId)
    }

}
