package com.arhohuttunen.coffeeshop.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
}
