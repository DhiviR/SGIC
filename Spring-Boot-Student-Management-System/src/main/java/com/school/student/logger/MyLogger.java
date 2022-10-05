package com.school.student.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
    private static FileHandler fileTxt;
    private static SimpleFormatter formatterTxt;
    private final static Logger logger = Logger.getLogger(MyLogger.class.getName());

    public static void setup() {
	LogManager.getLogManager().reset();
	logger.setLevel(Level.ALL);

	ConsoleHandler consoleHandler = new ConsoleHandler();
	consoleHandler.setLevel(Level.SEVERE);
	logger.addHandler(consoleHandler);

	try {
	    fileTxt = new FileHandler("Logging.txt", true);
	    formatterTxt = new SimpleFormatter();
	    fileTxt.setFormatter(formatterTxt);
	    logger.setLevel(Level.INFO);
	    logger.addHandler(fileTxt);
	} catch (IOException e) {
	    logger.log(Level.SEVERE, "File logger not working", e);
	}
    }
}
