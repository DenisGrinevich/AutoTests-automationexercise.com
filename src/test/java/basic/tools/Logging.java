package basic.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public static void info(String text) {
        logger.info(text);
    }

    public static void error(String text){
        logger.error(text);
    }
}