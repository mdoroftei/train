package com.exercises.train.helper;

import java.util.List;

import com.exercises.train.carts.Cart;
import com.exercises.train.carts.Head;

import static com.exercises.train.enums.CartConnections.*;

/**
 * Created by marius on 2/6/2018.
 */
public class CartHelper {

    public String print(List<Cart> train) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < train.size(); i++) {
            if (i == train.size() - 1 && train.get(i) instanceof Head) {
                stringBuilder.append(train.get(i).print())
                        .append(END_HEAD.toValue());
            } else {
                stringBuilder.append(wrapCart(train.get(i)));
                if(i < train.size() - 1) {
                    stringBuilder.append(CONNECTOR.toValue());
                }
            }
        }
        return stringBuilder.toString();
    }

    private String wrapCart(Cart cart) {
        if (cart instanceof Head) {
            return HEAD_HEAD.toValue() + cart.print();
        }
        return WRAPPER.toValue() + cart.print() + WRAPPER.toValue();
    }
}
