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
        assertEquals(90.0, finalPrice, 0.001); // 100 - 10%
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
        assertEquals(170.0, finalPrice, 0.001); // 200 - 15%
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
        assertEquals(40.0, finalPrice, 0.001); // 50 - 20%
    }
}
