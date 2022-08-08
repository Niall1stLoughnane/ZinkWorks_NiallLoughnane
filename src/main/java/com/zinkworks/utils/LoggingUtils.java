/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is a common utility for logging purposes
 **/

package com.zinkworks.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.zinkworks.ZinWorksConstants.*;

public final class LoggingUtils {

    private LoggingUtils(){}

    private static final Logger logger = LoggerFactory.getLogger(LoggingUtils.class);

    public static void logMessage(String level, String cllass, String detail, String message) {
        switch (level) {
            case "INFO" :
                logger.info("" + LOG_LEVEL_INFO + "|||" + cllass + "|||" + detail + "|||" + message);
                return;
            case "ERROR" :
                logger.error(""+ LOG_LEVEL_ERROR + "|||" + cllass + "|||" + detail + "|||" + message);
                return;
            case "DEBUG" :
                logger.error("" + LOG_LEVEL_DEBUG + "|||" + cllass + "|||" + detail + "|||" + message);
                return;
            default:
                logger.info(LOG_LEVEL_INFO + "|||" + cllass + "|||" + detail + "|||" + message);
        }
    }
}
