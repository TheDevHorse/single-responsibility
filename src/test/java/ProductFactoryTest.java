import com.thedevhorse.factory.Product;
import com.thedevhorse.factory.ProductFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductFactoryTest {

    @Test
    void shouldCreateLaptopProductWithCorrectNameAndPrice() {
        // Given
        String type = "laptop";
        String name = "MacBook-Pro";
        double basePrice = 1000.0;
        String color = "black";

        // When
        Product product = ProductFactory.getProduct(type, name, basePrice, color);

        // Then
        assertEquals("MacBook-Pro", product.name());
        assertEquals(1500.0, product.price());
    }

    @Test
    void shouldCreatePhoneProductWithCorrectNameAndPrice() {
        // Given
        String type = "phone";
        String name = "iPhone-14";
        double basePrice = 800.0;
        String color = "green";

        // When
        Product product = ProductFactory.getProduct(type, name, basePrice, color);

        // Then
        assertEquals("iPhone-14", product.name());
        assertEquals(1600.0, product.price());
    }
}
