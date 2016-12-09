package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by dmytro on 04.12.16.
 */
public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggerMap;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggerMap = loggerMap;
    }

    public App() {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        Event event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1");

        event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2");

        event = context.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3");

        context.close();
    }

    public void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggerMap.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
