package com.thoughtworks.tdd;

public class Ticket {
    private int code;

    public Ticket() {
    }

    public Ticket(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
