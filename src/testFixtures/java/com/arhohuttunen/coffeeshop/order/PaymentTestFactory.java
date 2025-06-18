package com.arhohuttunen.coffeeshop.order;

import java.time.LocalDate;

import static com.arhohuttunen.coffeeshop.order.CreditCardTestFactory.aCreditCard;

public class PaymentTestFactory {
    public static Payment aPaymentForOrder(Order order) {
        return new Payment(order.getId(), aCreditCard(), LocalDate.now());
    }
}
