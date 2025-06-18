package com.arhohuttunen.coffeeshop.order.persistence;

import com.arhohuttunen.coffeeshop.domain.CreditCard;
import com.arhohuttunen.coffeeshop.order.Payment;
import com.arhohuttunen.coffeeshop.order.Payments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.NoSuchElementException;
import java.util.UUID;

import static com.arhohuttunen.coffeeshop.order.CreditCardTestFactory.aCreditCard;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@PersistenceTest
public class PaymentsJpaAdapterTest {
    @Autowired
    private Payments payments;

    @Test
    void creatingPaymentReturnsPersistedPayment() {
        var now = LocalDate.now();
        var creditCard = aCreditCard();
        var payment = new Payment(UUID.randomUUID(), creditCard, now);

        var persistedPayment = payments.save(payment);

        assertThat(persistedPayment.creditCard()).isEqualTo(creditCard);
        assertThat(persistedPayment.paid()).isEqualTo(now);
    }

    @Test
    void findingPreviouslyPersistedPaymentReturnsDetails() {
        var payment = payments.findPaymentByOrderId(UUID.fromString("757d9c0f-400f-4137-9aea-83e64ba3efb2"));

        var expectedCreditCard = new CreditCard("Michael Faraday", "11223344", Month.JANUARY, Year.of(2023));

        assertThat(payment.creditCard()).isEqualTo(expectedCreditCard);
    }

    @Test
    void findingNonExistingPaymentThrowsException() {
        assertThatThrownBy(() -> payments.findPaymentByOrderId(UUID.randomUUID())).isInstanceOf(NoSuchElementException.class);
    }
}
