package com.exercises.train.carts;

import com.exercises.train.enums.CartType;

/**
 * Created by marius on 12/21/2017.
 */
public class Head implements Cart {
    public String print() {
        return CartType.HEAD.getLongValue();
    }
}
