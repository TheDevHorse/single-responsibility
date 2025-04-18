import com.thedevhorse.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;
    private Product macbook;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        macbook = new Product("MacBook Pro", 10.0, "APPLE_MACBOOK_PRO");
        Product iphone = new Product("Iphone", 10.0, "APPLE_PHONE_15");

        cart.modifyCart(new AddProductCommand(iphone));
        cart.modifyCart(new AddProductCommand(macbook));
    }

    @Test
    void shouldAddProduct_WhenAddCommandExecuted() {
        // Given
        Product watch = new Product("Apple Watch", 5.0, "APPLE_WATCH");
        ProductCommand addCommand = new AddProductCommand(watch);

        // When
        cart.modifyCart(addCommand);

        // Then
        assertEquals(3, cart.getShoppingCart().size());
        assertTrue(cart.getShoppingCart().contains(watch));
    }

    @Test
    void shouldRemoveProduct_WhenRemoveCommandExecuted() {
        // Given
        ProductCommand removeCommand = new RemoveProductCommand(macbook);

        // When
        cart.modifyCart(removeCommand);

        // Then
        assertEquals(1, cart.getShoppingCart().size());
        assertFalse(cart.getShoppingCart().contains(macbook));
    }
}
