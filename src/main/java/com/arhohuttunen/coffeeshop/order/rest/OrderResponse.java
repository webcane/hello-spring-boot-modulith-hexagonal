package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.order.Order;
import com.arhohuttunen.coffeeshop.domain.Location;

import java.math.BigDecimal;
import java.util.List;

record OrderResponse(Location location, List<LineItemResponse> items, BigDecimal cost) {
    public static OrderResponse fromDomain(Order order) {
        return new OrderResponse(
                order.getLocation(),
                order.getItems().stream().map(LineItemResponse::fromDomain).toList(),
                order.getCost()
        );
    }
}
