package Quoripoob.src.domain;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

/**
 * Log class to record exceptions which catches exceptions and stores them in a file
 *
 * @author Diego Cardenas
 * @author Sebastian Cardona
 * @version 1.0
 */
public class Log {
    public static String name = "Quoridor";

    /**
     * Record an exception
     *
     * @param e exception to be recorded
     */
    public static void record(Exception e) {
        try {
            Logger logger = Logger.getLogger(name);
            logger.setUseParentHandlers(false);
            FileHandler file = new FileHandler(name + ".log", true);
            file.setFormatter(new SimpleFormatter());
            logger.addHandler(file);
            logger.log(Level.SEVERE, e.toString(), e);
            file.close();
        } catch (Exception oe) {
            oe.printStackTrace();
            System.exit(0);
        }
    }
}
