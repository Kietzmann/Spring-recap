package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.Collection;

/**
 * Created by dkytsmen on 12/9/16.
 */
public class CombinedEventLogger implements EventLogger {
    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.stream().forEach(eventLogger -> eventLogger.logEvent(event));
    }
}
