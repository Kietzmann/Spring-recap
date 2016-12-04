package com.yet.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dmytro on 04.12.16.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;


    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        id = ThreadLocalRandom.current().nextInt(0, 10000000);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                ", dateFormat=" + dateFormat +
                '}';
    }
}
