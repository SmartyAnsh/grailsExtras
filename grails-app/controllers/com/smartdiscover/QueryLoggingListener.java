package com.smartdiscover;

import net.ttddyy.dsproxy.listener.logging.AbstractQueryLoggingListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryLoggingListener extends AbstractQueryLoggingListener {

    private static final Logger log = LoggerFactory.getLogger(QueryLoggingListener.class);

    @Override
    protected void writeLog(String message) {
        System.out.println(message);
    }
}
