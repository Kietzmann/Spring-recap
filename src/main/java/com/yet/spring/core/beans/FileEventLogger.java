package com.yet.spring.core.beans;

/**
 * Created by dmytro on 04.12.16.
 */
public class FileEventLogger implements EventLogger {
    private String fileName;


    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {

    }
}
