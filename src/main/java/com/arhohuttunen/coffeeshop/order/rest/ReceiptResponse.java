package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.order.Receipt;

import java.math.BigDecimal;
import java.time.LocalDate;

record ReceiptResponse(BigDecimal amount, LocalDate paid) {
    public static ReceiptResponse fromDomain(Receipt receipt) {
        return new ReceiptResponse(receipt.amount(), receipt.paid());
    }
}
