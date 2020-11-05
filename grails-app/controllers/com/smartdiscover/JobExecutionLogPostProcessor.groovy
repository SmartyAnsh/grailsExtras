package com.smartdiscover

import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.scheduling.quartz.SchedulerFactoryBean

class JobExecutionLogPostProcessor implements BeanPostProcessor {

    @Override
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean
    }

    @Override
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName == "quartzScheduler" && bean instanceof SchedulerFactoryBean) {
            bean.getScheduler().getListenerManager().addJobListener(new JobExecutionListener());
        }
        return bean
    }
}
