# Single Responsibility and Design Patterns

This project demonstrates how the **Factory**, **Strategy**, and **Command** design patterns are used to follow the **Single Responsibility Principle (SRP)** in object-oriented software design.

---

## 🧠 What is the Single Responsibility Principle?

The **Single Responsibility Principle (SRP)** in software design means that a class, module, or function should have **only one reason to change**. In other words, it should have only one responsibility or job.

By enforcing SRP, we reduce the likelihood of side effects during code changes, improve maintainability, and support more modular, testable design.

**Design patterns** are powerful tools that help us achieve SRP in a clean and consistent way.

---

## 🏭 Factory Pattern – Only creates objects

The `ProductFactory` is responsible **only** for creating `Product` instances. It holds a mapping of product types to creation logic, which keeps object instantiation separated from business logic.

### ✅ SRP in Action

- `ProductFactory` handles object creation.
- `Phone` and `Laptop` focus on product-specific logic.

### 🔍 From the code:


```java
public static Product getProduct(String type, String name, double price, String color) {
    return operationMap.get(type).create(name, price, color);
}
```

This allows products to be created without exposing or duplicating instantiation logic across the system.

---

## 🧮 Strategy Pattern – Each class performs one algorithm

The `Strategy` pattern enables the use of interchangeable discount algorithms. Each strategy class encapsulates a **single pricing rule**.

### ✅ SRP in Action

- Each class represents one algorithm.
- `PriceCalculator` delegates logic, and does not implement it.

### 🔍 From the code:

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

## 🧾 Command Pattern – Each class represents a single action

The `Command` pattern encapsulates actions such as **adding** or **removing** a product from the shopping cart in distinct classes.

### ✅ SRP in Action

- Each command performs one action.
- `ShoppingCart` doesn’t manage the logic itself, only delegates.

### 🔍 From the code:

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

## ✅ Conclusion

By using these design patterns:

| Pattern   | SRP Responsibility Example              |
|-----------|------------------------------------------|
| Factory   | Only creates objects                     |
| Strategy  | Each class performs one algorithm        |
| Command   | Each class represents a single action    |

These examples demonstrate how to structure code so that **each class has only one reason to change**. The result is a modular, extensible, and maintainable system — true to the spirit of the **Single Responsibility Principle**.
