package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.order.LineItem;
import com.arhohuttunen.coffeeshop.domain.Drink;
import com.arhohuttunen.coffeeshop.domain.Milk;
import com.arhohuttunen.coffeeshop.domain.Size;

record LineItemResponse(Drink drink, Milk milk, Size size, Integer quantity) {
    public static LineItemResponse fromDomain(LineItem lineItem) {
        return new LineItemResponse(
                lineItem.drink(),
                lineItem.milk(), lineItem.size(), lineItem.quantity()
        );
    }
}
