package com.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class LogTest {

    private static final Log LOG = LogFactory.getLog(LogTest.class);

    /**
     * 修改配置文件日志等级可打印不同的结果
     */
    @Test
    public void logTest() {
        LOG.debug("debug");
        LOG.info("info");
        LOG.warn("warn");
        LOG.error("error");
    }
}
