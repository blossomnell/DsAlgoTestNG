package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class LoggerLoad {
    private static final Logger logger = LogManager.getLogger(LoggerLoad.class);

    // Static block to ensure the logs directory exists
    static {
        try {
            File logsDir = new File("logs");
            if (!logsDir.exists()) {
                logsDir.mkdir();
                logger.info("Logs directory created at: " + logsDir.getAbsolutePath());
            }
        } catch (Exception e) {
            logger.error("Failed to create logs directory: " + e.getMessage());
        }
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }
}
