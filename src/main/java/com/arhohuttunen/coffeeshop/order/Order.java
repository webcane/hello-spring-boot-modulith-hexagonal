package com.arhohuttunen.coffeeshop.order;

import com.arhohuttunen.coffeeshop.domain.Location;
import com.arhohuttunen.coffeeshop.domain.Status;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final Location location;
    private final List<LineItem> items;
    private UUID id = UUID.randomUUID();
    private Status status = Status.PAYMENT_EXPECTED;

    public Order(Location location, List<LineItem> items) {
        this.location = location;
        this.items = items;
    }

    public Order(UUID id, Location location, List<LineItem> items, Status status) {
        this.id = id;
        this.location = location;
        this.items = items;
        this.status = status;
    }

    public boolean canBeCancelled() {
        return status == Status.PAYMENT_EXPECTED;
    }

    public BigDecimal getCost() {
        return items.stream().map(LineItem::getCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Order update(Order order) {
        if (status == Status.PAID) {
            throw new IllegalStateException("Order is already paid");
        }
        return new Order(id, order.getLocation(), order.getItems(), status);
    }

    public Order markPaid() {
        if (status != Status.PAYMENT_EXPECTED) {
            throw new IllegalStateException("Order is already paid");
        }
        status = Status.PAID;
        return this;
    }

    public Order markBeingPrepared() {
        if (status != Status.PAID) {
            throw new IllegalStateException("Order is not paid");
        }
        status = Status.PREPARING;
        return this;
    }

    public Order markPrepared() {
        if (status != Status.PREPARING) {
            throw new IllegalStateException("Order is not being prepared");
        }
        status = Status.READY;
        return this;
    }

    public Order markTaken() {
        if (status != Status.READY) {
            throw new IllegalStateException("Order is not ready");
        }
        status = Status.TAKEN;
        return this;
    }
}
