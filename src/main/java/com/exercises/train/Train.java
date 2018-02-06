package com.exercises.train;

import com.exercises.train.carts.*;

import java.util.*;

import com.exercises.train.enums.CartConnections;
import com.exercises.train.enums.CartType;

public class Train {

	List<Cart> myTrain = new LinkedList<>();

	public Train(String structure) {
        myTrain.addAll(CartFactory.cartFactory(structure));
	}

	public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Cart> it = myTrain.iterator();
        while (it.hasNext()){
            Cart cart = it.next();
            if(myTrain.indexOf(cart) == myTrain.size()-1) {
                stringBuilder.append(wrapCart(cart));
            } else {
                stringBuilder.append(bindCart(cart));
            }
        }
        return stringBuilder.toString();
	}

    private String wrapCart(Cart cart) {
        StringBuilder stringBuilder = new StringBuilder();
        if (cart instanceof HeadHead) {
            return stringBuilder.append(CartConnections.HEAD_HEAD.toValue()).append(cart.print()).toString();
        }
        if (cart instanceof EndHead) {
            return stringBuilder.append(cart.print()).append(CartConnections.END_HEAD.toValue()).toString();
        }
        return stringBuilder.append(CartConnections.WRAPPER.toValue()).append(cart.print()).append(CartConnections.WRAPPER.toValue()).toString();
    }

    private String bindCart(Cart cart) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(wrapCart(cart)).append(CartConnections.CONNECTOR.toValue()).toString();
    }

	public void detachEnd(){
		myTrain.remove(myTrain.size()-1);
	}

	public void detachHead(){
        myTrain.remove(0);
	}

	public boolean fill(){
        boolean toFill = false;
            for (Cart cart : myTrain) {
                if(cart instanceof EmptyCargoCart) {
                    myTrain.set(myTrain.indexOf(cart), new FullCargoCart());
                    toFill = true;
                    break;
                }
            }
        return  toFill;
	}

}
