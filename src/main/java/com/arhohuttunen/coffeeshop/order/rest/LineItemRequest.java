package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.order.LineItem;
import com.arhohuttunen.coffeeshop.domain.Drink;
import com.arhohuttunen.coffeeshop.domain.Milk;
import com.arhohuttunen.coffeeshop.domain.Size;

record LineItemRequest(Drink drink, Milk milk, Size size, Integer quantity) {
    public LineItem toDomain() {
        return new LineItem(drink, milk, size, quantity);
    }
}
