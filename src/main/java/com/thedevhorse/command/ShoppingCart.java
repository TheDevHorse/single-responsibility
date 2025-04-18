package com.thedevhorse.command;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products = new ArrayList<>();

    public void modifyCart(ProductCommand command) {
        command.execute(products);
    }

    public List<Product> getShoppingCart() {
        return products;
    }
}
