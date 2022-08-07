package com.zinkworks.utils;

import org.junit.jupiter.api.Test;

public class LoggingUtilsTest {

    @Test
    public void testLoggingUtils() {
        LoggingUtils.logMessage("INFO", "class", "detail","message");
        LoggingUtils.logMessage("DEBUG", "class", "detail","message");
        LoggingUtils.logMessage("ERROR", "class", "detail","message");
        LoggingUtils.logMessage("HEAD", "class", "detail","message");
        LoggingUtils.logMessage("REACE", "class", "detail","message");
    }
}
