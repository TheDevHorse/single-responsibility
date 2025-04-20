# Applying the Single Responsibility Principle with Design Patterns

This project demonstrates how the **Factory**, **Strategy**, and **Command** design patterns are used to follow the **Single Responsibility Principle (SRP)** in object-oriented software design.

---

##  What is the Single Responsibility Principle?

The **Single Responsibility Principle (SRP)** in software design means that a class, module, or function should have **only one reason to change**. In other words, it should have only one responsibility or job.

Enforcing SRP reduces the likelihood of side effects when code changes, improves maintainability, and promotes modular, testable design.

**Design patterns** are powerful tools that help achieve SRP in a clean, consistent way.

---

## Factory Pattern – Centralized Object Creation

Object creation can become scattered and repetitive across a codebase. To avoid this, the `Factory` pattern centralizes instantiation logic. 

In this project, `ProductFactory` is responsible for creating 'Product' instances like 'Phone' and 'Laptop', each mapped to its own factory method. This keeps construction logic separate from business logic, aligning with SRP.

###  Implementation Overview

- `ProductFactory` encapsulates **only object creation**.
- `Phone` and `Laptop` are responsible **only for product behavior and internal logic**.
- Business logic remains clean and focused, free of instantiation details.

###  Code Example:

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

This approach allows consistent, centralized creation of product instances without exposing or duplicating instantiation logic throughout the system.

---

##  Strategy Pattern – Encapsulated Algorithms

The `Strategy` pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It separates the algorithm from the context in which it’s used, supporting SRP by isolating calculation logic.

In this project, it’s applied to discount calculation. Since discount rules vary by product type and may evolve independently, each rule is implemented in its own class. `PriceCalculator` delegates the calculation to the selected strategy, keeping concerns well-separated.

###  Implementation Overview

- Each strategy class encapsulates a **single discount rule.**
- `PriceCalculator` applies the strategy without knowing its internal logic.
- New algorithms can be added without modifying existing code.

###  Code Example:

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

##  Command Pattern – Isolated Actions

The `Command` pattern encapsulates a request as an object, enabling parameterization, queuing, and execution of actions independently of the invoking code.

In this project, it's used to model operations on a shopping cart — such as adding or removing a product — by placing each action in its own command class. This keeps the `ShoppingCart` focused on execution, not behavior.

### Implementation Overview

- Each command class **encapsulates a single, well-defined action.**
- `ShoppingCart` delegates execution without knowing the action's logic.
- New actions can be added without changing existing code.

###  Code Example:

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

By applying these design patterns, each responsibility in the system is clearly separated:

- The **Factory** pattern centralizes object creation, so creation logic doesn’t leak into business logic. 

- The **Strategy** pattern encapsulates algorithms (like discount calculations) into separate, reusable classes. 

- The **Command** pattern breaks down user actions into modular, isolated commands.

These implementations show how to structure code so that **each class has only one reason to change,** in accordance with the **Single Responsibility Principle.** The result is a modular, extensible, and maintainable system.