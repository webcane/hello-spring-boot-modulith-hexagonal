package com.arhohuttunen.coffeeshop.order.persistence;

import com.arhohuttunen.coffeeshop.order.Payments;
import com.arhohuttunen.coffeeshop.order.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class PaymentsJpaAdapter implements Payments {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment findPaymentByOrderId(UUID orderId) {
        return paymentJpaRepository.findByOrderId(orderId)
                .map(PaymentEntity::toDomain)
                .orElseThrow();
    }

    @Override
    public Payment save(Payment payment) {
        return paymentJpaRepository.save(PaymentEntity.fromDomain(payment)).toDomain();
    }
}
