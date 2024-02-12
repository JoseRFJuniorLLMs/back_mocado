package com.loiane.course.enums;

public enum Category {
    FRONT_END("Language"), BACK_END("Business");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value; // required for @ValueOfEnum
    }

}
