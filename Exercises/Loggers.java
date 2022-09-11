import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loggers {

    /**
     * Loggers are used to log messages to specific system
     * Logger object obtained by calling getLogger method
     *      Logger logger = Logger.getLogger(ClassName.class);
     *
     * Logging messages will be forwarded to registered Handler objects.
     * Handlers forward the message to different destinations: Console, files, OS logs etc.
     *
     * Each logger has a level associated with it.
     * The levels with descending order,
     *      SEVERE - Indicates a serious failure.
     *      WARNING - Indicates a potential problem
     *      INFO - Informational messages
     *      CONFIG - Configuration messages
     *      FINE - Provides tracing information
     *      FINER - Fairly detailed tracing message
     *      FINEST - Highly detailed tracing message
     *
     *      ALL - Indicates that all messages should be logged
     *      OFF - Can be used to turn off logging
     *
     * Log4j and SLF4J are popular frameworks for Loggers
     *
     *
     */

    static Logger logger = LoggerFactory.getLogger(Loggers.class);

    public static void main(String[] args) {
        logger.error("Error");
        logger.info("Info");
        logger.warn("Warning");
    }


}
