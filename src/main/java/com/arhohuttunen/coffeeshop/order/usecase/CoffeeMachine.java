package com.arhohuttunen.coffeeshop.order.usecase;

import com.arhohuttunen.coffeeshop.architecture.UseCase;
import com.arhohuttunen.coffeeshop.order.PreparingCoffee;
import com.arhohuttunen.coffeeshop.order.Order;
import com.arhohuttunen.coffeeshop.order.Orders;

import java.util.UUID;

@UseCase
class CoffeeMachine implements PreparingCoffee {
    private final Orders orders;

    public CoffeeMachine(Orders orders) {
        this.orders = orders;
    }

    @Override
    public Order startPreparingOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        return orders.save(order.markBeingPrepared());
    }

    @Override
    public Order finishPreparingOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        return orders.save(order.markPrepared());
    }
}
