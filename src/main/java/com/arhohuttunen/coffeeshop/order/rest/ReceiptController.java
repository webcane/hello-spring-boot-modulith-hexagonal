package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.order.OrderingCoffee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
class ReceiptController {
    private final OrderingCoffee orderingCoffee;

    @GetMapping("/receipt/{id}")
    ResponseEntity<ReceiptResponse> readReceipt(@PathVariable UUID id) {
        var receipt = orderingCoffee.readReceipt(id);
        return ResponseEntity.ok(ReceiptResponse.fromDomain(receipt));
    }

    @DeleteMapping("/receipt/{id}")
    ResponseEntity<OrderResponse> completeOrder(@PathVariable UUID id) {
        var order = orderingCoffee.takeOrder(id);
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }
}
