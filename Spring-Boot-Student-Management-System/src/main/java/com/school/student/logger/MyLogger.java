package com.school.student.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    public static void setup() throws IOException {
	Logger logger = Logger.getLogger(MyLogger.class.getName());

//	Logger rootLogger = Logger.getLogger("");

	fileTxt = new FileHandler("Logging.txt");
	formatterTxt = new SimpleFormatter();
	fileTxt.setFormatter(formatterTxt);

	logger.setLevel(Level.INFO);
	logger.addHandler(fileTxt);

    }
}
