package com.thedevhorse.command;

import java.util.List;

public class RemoveProductCommand implements ProductCommand {

    private final Product product;

    public RemoveProductCommand(Product product) {
        this.product = product;
    }

    @Override
    public void execute(List<Product> shoppingCart) {
        shoppingCart.removeIf(p -> p.productCode().equals(product.productCode()));
    }
}
