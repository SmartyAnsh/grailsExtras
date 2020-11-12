# grailsExtras
Grails project with extra (unusual) configurations or implementation

Extra implementations:

1. Added implementation of the JobListenerSupport to log start and finish execution of every job. Look for JobExecutionListener and JobExecutionLogPostProcessor classes

2. PGEnumUserType added to support Postgres Enum in Grails domain classes. Look for PGEnumUserType and UserProfile classes

3. SQL Query Logging added to log exact sql queries run by hibernate with parameters. Look for QueryLoggingListener, ProxyDataSourceBuilder, and DatasourceProxyBeanPostProcessor classes.
