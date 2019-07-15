package com.thoughtworks.tdd;

public enum ErrorMessageEnum {
    NO_TICKET("NO_TICKET", "Please provide your parking ticket."),
    UNRECOGNIZED_TICKET("UNRECOGNIZED_TICKET", "Unrecognized parking ticket."),
    NO_POSITION("NO_POSITION", "Not enough position.");
    private String value;
    private String desc;

    ErrorMessageEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
