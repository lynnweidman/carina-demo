package com.zebrunner.carina.demo.enums;

public enum HeaderIconLink {
    TIPS("tip-us"),
    YOUTUBE("youtube"),
    INSTAGRAM("instagram"),
    RSS("rss"),
    EV("car"),
    MERCH("cart"),
    LOG_IN("login"),
    SIGN_UP("user-plus");

    private String value;

    HeaderIconLink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
