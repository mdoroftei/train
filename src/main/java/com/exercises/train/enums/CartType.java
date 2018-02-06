package com.exercises.train.enums;

import com.exercises.train.carts.Cart;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marius on 12/21/2017.
 */
public enum CartType {
    HEAD('H', "HHHH"),
    PASSENGER('P', "OOOO"),
    RESTAURANT('R', "hThT"),
    EMPTY_CARGO('C', "____"),
    FULL_CARGO('F', "^^^^");

    private char shortValue;
    private String longValue;

    private static final Map<Character, CartType> cartMap = Collections.unmodifiableMap(initMapping());

    private static Map<Character, CartType> initMapping() {
        Map<Character, CartType> cartMap = new HashMap<>();
        for (CartType cartType : CartType.values()) {
            cartMap.put(cartType.getShortValue(), cartType);
        }
        return cartMap;
    }

    CartType(char shortValue, String longValue)
    {
        this.shortValue = shortValue;
        this.longValue = longValue;
    }

    public String getLongValue() {
        return longValue;
    }

    public char getShortValue() {
        return shortValue;
    }

    public static CartType of(char c) {
        return cartMap.get(c);
    }
}
