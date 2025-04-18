package com.thedevhorse.command;


import java.util.List;

public class AddProductCommand implements ProductCommand {

    private final Product product;

    public AddProductCommand(Product product) {
        this.product = product;
    }

    @Override
    public void execute(List<Product> shoppingCart) {
        shoppingCart.add(product);
    }
}
