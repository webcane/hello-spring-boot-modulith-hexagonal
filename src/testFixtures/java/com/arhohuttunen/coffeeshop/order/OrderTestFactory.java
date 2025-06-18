package com.arhohuttunen.coffeeshop.order;

import com.arhohuttunen.coffeeshop.domain.Drink;
import com.arhohuttunen.coffeeshop.domain.Location;
import com.arhohuttunen.coffeeshop.domain.Milk;
import com.arhohuttunen.coffeeshop.domain.Size;

import java.util.List;

public class OrderTestFactory {
    public static Order anOrder() {
        return new Order(Location.TAKE_AWAY, List.of(new LineItem(Drink.LATTE, Milk.WHOLE, Size.LARGE, 1)));
    }

    public static Order aPaidOrder() {
        return anOrder()
                .markPaid();
    }

    public static Order anOrderInPreparation() {
        return aPaidOrder()
                .markBeingPrepared();
    }

    public static Order aReadyOrder() {
        return anOrderInPreparation()
                .markPrepared();
    }
}
