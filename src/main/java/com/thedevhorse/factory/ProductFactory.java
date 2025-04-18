package com.thedevhorse.factory;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {

    private static final Map<String, ProductFactoryMethod> operationMap = new HashMap<>();

    static {
        operationMap.put("Laptop", Laptop::create);
        operationMap.put("Phone", Phone::create);
    }

    public static Product getProduct(String type, String name, double price, String color) {
        return operationMap.get(type).create(
                name,
                price,
                color
        );
    }

    interface ProductFactoryMethod {
        Product create(String name, double price, String color);
    }
}
