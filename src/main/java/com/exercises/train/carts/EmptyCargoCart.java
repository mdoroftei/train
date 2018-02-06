package com.exercises.train.carts;

import com.exercises.train.enums.CartType;

/**
 * Created by marius on 12/21/2017.
 */
public class EmptyCargoCart extends CargoCart {
    @Override
    public String print() {
        return CartType.CARGO.getLongValue();
    }
}
