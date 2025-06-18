package com.arhohuttunen.coffeeshop.order.rest;

import com.arhohuttunen.coffeeshop.CoffeeShopTestConfig;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@WebMvcTest
@Import(CoffeeShopTestConfig.class)
public @interface RestResourceTest {
}
