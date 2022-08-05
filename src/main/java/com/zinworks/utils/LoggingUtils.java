package com.zinworks.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtils {

    private static final Logger logger = LoggerFactory.getLogger(LoggingUtils.class);

    public static void logMessage(String level, String cllass, String detail, String message) {
        switch (level) {
            case "INFO" :
                logger.info("INFO|||" + cllass + "|||" + detail + "|||" + message);
            case "ERROR" :
                logger.error("ERROR|||" + cllass + "|||" + detail + "|||" + message);
            case "DEBUG" :
                logger.error("DEBUG|||" + cllass + "|||" + detail + "|||" + message);
        }
    }
}
