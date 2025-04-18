# Single Responsibility and Design Patterns

This project demonstrates how the **Factory**, **Strategy**, and **Command** design patterns are used to follow the **Single Responsibility Principle (SRP)** in object-oriented software design.

---

##  What is the Single Responsibility Principle?

The **Single Responsibility Principle (SRP)** in software design means that a class, module, or function should have **only one reason to change**. In other words, it should have only one responsibility or job.

By enforcing SRP, we reduce the likelihood of side effects during code changes, improve maintainability, and support more modular, testable design.

**Design patterns** are powerful tools that help us achieve SRP in a clean and consistent way.

---

## Factory Pattern 

In many systems, object creation logic is often scattered across different parts of the codebase — leading to duplication, tight coupling, and violations of SRP. The **Factory pattern** addresses this by centralizing creation logic.

In this project, the `ProductFactory` is solely responsible for creating instances of products like `Phone` and `Laptop`. It uses a mapping of product types to their specific factory methods. This ensures that classes consuming products don't need to know how to construct them — only how to request them.

###  SRP in Action

- `ProductFactory` encapsulates **only object creation**.
- `Phone` and `Laptop` are responsible **only for product behavior and internal logic**.
- Business logic remains clean and focused, free of instantiation details.

###  From the code:

```java
public static Product getProduct(String type, String name, double price, String color) {
    return operationMap.get(type).create(name, price, color);
}
```

```java
public class Phone implements Product {
    public static Product create(String name, double price, String color) {
        return new Phone(name, price, color);
    }
}
```

```java
public class Laptop implements Product {
    public static Product create(String name, double price, String color) {
        return new Laptop(name, price, color);
    }
}
```

This allows products to be created without exposing or duplicating instantiation logic across the system.

---

##  Strategy Pattern 

The `Strategy` pattern enables the use of interchangeable discount algorithms. Each strategy class encapsulates a **single pricing rule**.

###  SRP in Action

- Each class represents one algorithm.
- `PriceCalculator` delegates logic, and does not implement it.

###  From the code:

```java
public class ElectronicsDiscountStrategy implements DiscountStrategy {
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.15;
    }
}
```

```java
public class BooksDiscountStrategy implements DiscountStrategy {
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.20;
    }
}
```

```java
public class PriceCalculator {
    public double calculateFinalPrice(Product product) {
        return discountStrategy.calculateDiscount(product);
    }
}
```

Each algorithm is isolated and easy to modify, test, or extend independently.

---

##  Command Pattern

The `Command` pattern encapsulates actions such as **adding** or **removing** a product from the shopping cart in distinct classes.

###  SRP in Action

- Each command performs one action.
- `ShoppingCart` doesn’t manage the logic itself, only delegates.

###  From the code:

```java
public class AddProductCommand implements ProductCommand {
    public void execute(List<Product> shoppingCart) {
        shoppingCart.add(product);
    }
}
```

```java
public class RemoveProductCommand implements ProductCommand {
    public void execute(List<Product> shoppingCart) {
        shoppingCart.removeIf(p -> p.productCode().equals(product.productCode()));
    }
}
```

```java
public class ShoppingCart {
    public void modifyCart(ProductCommand command) {
        command.execute(products);
    }
}
```

Every action has a well-defined, isolated responsibility.

---

## Conclusion

By using these design patterns, each responsibility in the system is clearly separated:

The **Factory** pattern ensures that object creation is handled in one place, so creation logic doesn't leak into business logic. The **Strategy** pattern encapsulates each algorithm (like discount calculation) in its own class, making the system flexible and easily extendable. The **Command** pattern delegates actions like adding or removing products from the cart to individual classes, keeping responsibilities isolated and focused.

These examples demonstrate how to structure code so that **each class has only one reason to change**. The result is a modular, extensible, and maintainable system — true to the spirit of the **Single Responsibility Principle**.
