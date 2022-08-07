package com.zinkworks.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.zinkworks.ZinWorksConstants.LOG_LEVEL_INFO;

public final class LoggingUtils {

    private LoggingUtils(){}

    private static final Logger logger = LoggerFactory.getLogger(LoggingUtils.class);

    public static void logMessage(String level, String cllass, String detail, String message) {
        switch (level) {
            case "INFO" :
                logger.info("" + LOG_LEVEL_INFO + "|||" + cllass + "|||" + detail + "|||" + message);
                return;
            case "ERROR" :
                logger.error(""+ ERROR + "|||" + cllass + "|||" + detail + "|||" + message);
                return;
            case "DEBUG" :
                logger.error("" + DEBUG + "|||" + cllass + "|||" + detail + "|||" + message);
                return;
            default
                logger.info(LOG_LEVEL_INFO + "|||" + cllass + "|||" + detail + "|||" + message);
        }
    }
}
