# grailsExtras
Grails project with extra (unusual) configurations or implementation

Extra implementations:

1. Added implementation of the _JobListenerSupport_ to log start and finish execution of every job. Look for _JobExecutionListener_ and _JobExecutionLogPostProcessor_ classes

2. Postgres Enum support added to Grails domain classes. Look for _PGEnumUserType_ and _UserProfile_ classes

3. SQL Query Logging added to log exact sql queries run by hibernate with parameters. Look for _QueryLoggingListener_, _ProxyDataSourceBuilder_, and _DatasourceProxyBeanPostProcessor_ classes.
