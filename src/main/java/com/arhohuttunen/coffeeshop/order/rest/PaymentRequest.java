package com.arhohuttunen.coffeeshop.order.rest;

import jakarta.validation.constraints.NotNull;

record PaymentRequest(
        @NotNull String cardHolderName,
        @NotNull String cardNumber,
        @NotNull Integer expiryMonth,
        @NotNull Integer expiryYear) {}
