package com.yet.spring.core.beans; /**
 * Created by dmytro on 04.12.16.
 */
public class ConsoleEventLogger implements EventLogger{
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
