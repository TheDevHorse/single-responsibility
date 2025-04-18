# Single Responsibility and Design Patterns

This project demonstrates how the **Factory**, **Strategy**, and **Command** design patterns are used to follow the **Single Responsibility Principle (SRP)** in object-oriented software design.

---

##  What is the Single Responsibility Principle?

The **Single Responsibility Principle (SRP)** in software design means that a class, module, or function should have **only one reason to change**. In other words, it should have only one responsibility or job.

By enforcing SRP, we reduce the likelihood of side effects during code changes, improve maintainability, and support more modular, testable design.

**Design patterns** are powerful tools that help us achieve SRP in a clean and consistent way.

---

## Factory Pattern 

Object creation can become scattered and repetitive across a codebase. To avoid this, the `Factory` pattern centralizes instantiation logic. In this project, `ProductFactory` handles the creation of products like `Phone` and `Laptop`, mapping each type to its factory method. This keeps construction logic separate from business logic and adheres to SRP.


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

##  Strategy Pattern – Each class performs one algorithm

The `Strategy` pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable. It promotes flexibility by separating the algorithm from the class that uses it.

In this project, it's applied to handle discount logic. Since discount rules can vary across product types and evolve over time, each rule is placed in its own class. `PriceCalculator` delegates the calculation to the selected strategy — keeping responsibilities isolated and aligned with SRP.

###  SRP in Action

- Each strategy class encapsulates one specific discount rule.
- `PriceCalculator` applies the strategy without knowing its internal logic.
- New algorithms can be added without modifying existing code.
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

##  Command Pattern – Each class represents a single action

The `Command` pattern encapsulates a request as an object, allowing you to parameterize, queue, and execute actions independently of the calling code.

In this project, it's used to model operations on a shopping cart — such as adding or removing a product — by placing each action in its own command class. This keeps the `ShoppingCart` focused on execution, not behavior.

### SRP in Action

- Each command class encapsulates a single, well-defined operation.
- `ShoppingCart` delegates execution without knowing the action's logic.
- New actions can be added without changing existing code.

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
