package log;

import org.apache.log4j.Logger;

/**
 * @author mohammad.makki
 *
 */
public class Log {
	// Initialize Log4j logs
	private static Logger log = Logger.getLogger(Log.class.getName());//
	
	// Need to create these methods, so that they can be called  
	public static void info(String message) {
		log.info(message);
		System.out.println("INFO :" + message);
	}

	public static void error(String message) {
		log.error(message);
		System.out.println("ERROR :" + message);
	}
}