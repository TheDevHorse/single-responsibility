package com.thedevhorse.strategy;

public class BooksDiscount implements Discount {

    @Override
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.20;
    }
}
