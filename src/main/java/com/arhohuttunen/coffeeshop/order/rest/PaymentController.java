package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.order.OrderingCoffee;
import com.arhohuttunen.coffeeshop.domain.CreditCard;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Month;
import java.time.Year;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
class PaymentController {
    private final OrderingCoffee orderingCoffee;

    @PutMapping("/payment/{id}")
    ResponseEntity<PaymentResponse> payOrder(@PathVariable UUID id, @Valid @RequestBody PaymentRequest request) {
        var payment = orderingCoffee.payOrder(id,
                new CreditCard(
                        request.cardHolderName(),
                        request.cardNumber(),
                        Month.of(request.expiryMonth()),
                        Year.of(request.expiryYear())
                )
        );
        return ResponseEntity.ok(PaymentResponse.fromDomain(payment));
    }
}
