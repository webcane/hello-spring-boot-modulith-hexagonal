package com.arhohuttunen.coffeeshop.order.usecase;

import com.arhohuttunen.coffeeshop.architecture.UseCase;
import com.arhohuttunen.coffeeshop.order.OrderingCoffee;
import com.arhohuttunen.coffeeshop.order.Order;
import com.arhohuttunen.coffeeshop.order.Orders;
import com.arhohuttunen.coffeeshop.order.Payments;
import com.arhohuttunen.coffeeshop.domain.CreditCard;
import com.arhohuttunen.coffeeshop.order.Payment;
import com.arhohuttunen.coffeeshop.order.Receipt;

import java.time.LocalDate;
import java.util.UUID;

@UseCase
class CoffeeShop implements OrderingCoffee {
    private final Orders orders;
    private final Payments payments;

    public CoffeeShop(Orders orders, Payments payments) {
        this.orders = orders;
        this.payments = payments;
    }

    @Override
    public Order placeOrder(Order order) {
        return orders.save(order);
    }

    @Override
    public Order updateOrder(UUID orderId, Order order) {
        var existingOrder = orders.findOrderById(orderId);

        return orders.save(existingOrder.update(order));
    }

    @Override
    public void cancelOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        if (!order.canBeCancelled()) {
            throw new IllegalStateException("Order is already paid");
        }

        orders.deleteById(orderId);
    }

    @Override
    public Payment payOrder(UUID orderId, CreditCard creditCard) {
        var order = orders.findOrderById(orderId);

        orders.save(order.markPaid());

        return payments.save(new Payment(orderId, creditCard, LocalDate.now()));
    }

    @Override
    public Receipt readReceipt(UUID orderId) {
        var order = orders.findOrderById(orderId);
        var payment = payments.findPaymentByOrderId(orderId);

        return new Receipt(order.getCost(), payment.paid());
    }

    @Override
    public Order takeOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        return orders.save(order.markTaken());
    }
}
