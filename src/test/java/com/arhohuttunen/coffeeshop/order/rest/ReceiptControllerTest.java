package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.order.Orders;
import com.arhohuttunen.coffeeshop.order.Payments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static com.arhohuttunen.coffeeshop.order.OrderTestFactory.aReadyOrder;
import static com.arhohuttunen.coffeeshop.order.OrderTestFactory.anOrder;
import static com.arhohuttunen.coffeeshop.order.PaymentTestFactory.aPaymentForOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestResourceTest
public class ReceiptControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Orders orders;

    @Autowired
    private Payments payments;

    @Test
    void readReceipt() throws Exception {
        var order = orders.save(anOrder());
        payments.save(aPaymentForOrder(order));

        mockMvc.perform(get("/receipt/{id}", order.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void completeOrder() throws Exception {
        var order = orders.save(aReadyOrder());

        mockMvc.perform(delete("/receipt/{id}", order.getId()))
                .andExpect(status().isOk());
    }
}
