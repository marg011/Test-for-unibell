package com.unibell.test.dto;

public enum ContactType {
    PHONE("phone"),
    EMAIL("email");

    private final String type;

    ContactType(String type) { this.type = type; }

    public String getValue() {
        return type;
    }
}
