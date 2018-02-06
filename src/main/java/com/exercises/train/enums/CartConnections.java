package com.exercises.train.enums;

/**
 * Created by marius on 12/21/2017.
 */
public enum CartConnections {
    HEAD_HEAD("<"),
    END_HEAD(">"),
    WRAPPER("|"),
    CONNECTOR("::");

    private String value;

    CartConnections(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }
}
