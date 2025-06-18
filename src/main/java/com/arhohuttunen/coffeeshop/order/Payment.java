package com.arhohuttunen.coffeeshop.order;

import com.arhohuttunen.coffeeshop.domain.CreditCard;

import java.time.LocalDate;
import java.util.UUID;

public record Payment(UUID orderId, CreditCard creditCard, LocalDate paid) { }
