package com.kenzie.packages.logger.service;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private final String logFile = "book_search_log.txt";
    private PrintWriter writer;

    //static Singleton instance of Logger - there can be only one
    private static Logger logger = null;

    private Logger() {
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {}
    }

    public static synchronized Logger getInstance(){
        if(logger == null)
            logger = new Logger();
        return logger;
    }
    public void logMessage (String message) {
        writer.println(message);
    }

}