package com.exercises.train;

import com.exercises.train.carts.*;
import java.util.*;
import com.exercises.train.helper.CartHelper;

public class Train {

    private CartHelper cartHelper = new CartHelper();
	private List<Cart> myTrain = new LinkedList<>();

	public Train(String structure) {
        myTrain.addAll(CartFactory.cartFactory(structure));
	}

	public String print() {
        return cartHelper.print(myTrain);
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
