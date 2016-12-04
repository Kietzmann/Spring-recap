package com.yet.spring.core.beans; /**
 * Created by dmytro on 04.12.16.
 */
public class Client {
    private long id;
    private String fullName;

    public Client(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Client() {
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
