package com.exercises.train.carts;

import com.exercises.train.enums.CartType;

import java.util.*;

/**
 * Created by marius on 2/5/2018.
 */
public class CartFactory {

    private static final Map<CartType, Cart> cartMap = Collections.unmodifiableMap(initMapping());

    private static Map<CartType, Cart> initMapping() {
        Map<CartType, Cart> cartMap = new EnumMap<>(CartType.class);
        for (CartType cartType : CartType.values()) {
            cartMap.put(cartType, cartFactory(cartType));
        }
        return cartMap;
    }

    private static Cart cartFactory(CartType cartType) {
        switch (cartType) {
            case HEAD:
                return new Head();
            case PASSENGER:
                return new Passenger();
            case RESTAURANT:
                return new Restaurant();
            case EMPTY_CARGO:
                return new EmptyCargoCart();
            case FULL_CARGO:
                return new FullCargoCart();
            default:
                return null;
        }
    }

    public static List<Cart> cartFactory(String structure) {
        List<Cart> cartList = new LinkedList<>();
        for (char c : structure.toCharArray()) {
            cartList.add(cartMap.get(CartType.of(c)));
        }
        return cartList;
    }
}
