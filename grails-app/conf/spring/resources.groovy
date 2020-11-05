import com.smartdiscover.DatasourceProxyBeanPostProcessor
import com.smartdiscover.JobExecutionLogPostProcessor

// Place your Spring DSL code here
beans = {

    datasourceProxyBeanPostProcessor(DatasourceProxyBeanPostProcessor)
    jobExecutionLogPostProcessor(JobExecutionLogPostProcessor)

}
