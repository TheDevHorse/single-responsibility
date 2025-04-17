import com.thedevhorse.strategy.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {


    @Test
    void shouldApplyToysDiscount() {
        // Given
        Product product = new Product("Toy Car", 100.0);
        DiscountStrategy discountStrategy = new ToysDiscountStrategy();
        PriceCalculator strategy = new PriceCalculator(discountStrategy);

        // When
        double finalPrice = strategy.calculateFinalPrice(product);

        // Then
        assertEquals(10.0, finalPrice);
    }

    @Test
    void shouldApplyElectronicsDiscount() {
        // Given
        Product product = new Product("Smartphone", 200.0);
        DiscountStrategy discountStrategy = new ElectronicsDiscountStrategy();
        PriceCalculator strategy = new PriceCalculator(discountStrategy);

        // When
        double finalPrice = strategy.calculateFinalPrice(product);

        // Then
        assertEquals(30.0, finalPrice);
    }

    @Test
    void shouldApplyBooksDiscount() {
        // Given
        Product product = new Product("Java Book", 50.0);
        DiscountStrategy discountStrategy = new BooksDiscountStrategy();
        PriceCalculator strategy = new PriceCalculator(discountStrategy);

        // When
        double finalPrice = strategy.calculateFinalPrice(product);

        // Then
        assertEquals(10.0, finalPrice);
    }
}
