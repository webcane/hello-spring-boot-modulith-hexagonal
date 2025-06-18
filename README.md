# Hello Coffeeshop
A Spring Boot application structured with hexagonal architecture backed by the Spring Modulith library for modular design and enforcement, implemented as a single Gradle project
The idea was inspired by a [blog post](https://www.arhohuttunen.com/hexagonal-architecture-spring-boot/) and addresses some practical challenges that are often overlooked in similar examples.

![Gradle Build](https://github.com/webcane/hello-spring-boot-modulith-hexagonal/workflows/Gradle%20Build/badge.svg)

`package-info.java` files managed by Spring Modulith define allowed dependencies.
For example, the `persistence` outbound adapter may only access shared domain classes and related `order` ports:

```java
@ApplicationModule(allowedDependencies = {"architecture", "domain", "order"})
```
This means it does not have access to classes from the `rest` inbound adapter.
