package com.zebrunner.carina.demo.enums;

public enum HeaderButtonLink {
    NEWS("News"),
    REVIEWS("Reviews"),
    VIDEOS("Videos"),
    FEATURES("Features"),
    PHONE_FINDER("Phone Finder"),
    DEALS("Deals"),
    MERCH("Merch"),
    COVERAGE("Coverage"),
    CONTACT("Contact"),
    HOME("Home");


    private String value;

    HeaderButtonLink(String value) {this.value = value; }

    public String getValue() { return value; }
}


