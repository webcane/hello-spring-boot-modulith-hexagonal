package com.arhohuttunen.coffeeshop.order.persistence.stud;

import com.arhohuttunen.coffeeshop.order.Order;
import com.arhohuttunen.coffeeshop.order.OrderNotFound;
import com.arhohuttunen.coffeeshop.order.Orders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryOrders implements Orders {
    private final Map<UUID, Order> entities = new HashMap<>();

    @Override
    public Order findOrderById(UUID orderId) {
        var order = entities.get(orderId);
        if (order == null) {
            throw new OrderNotFound();
        }
        return order;
    }

    @Override
    public Order save(Order order) {
        entities.put(order.getId(), order);
        return order;
    }

    @Override
    public void deleteById(UUID orderId) {
        entities.remove(orderId);
    }
}
