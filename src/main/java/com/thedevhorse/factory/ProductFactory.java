package com.thedevhorse.factory;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {

    @FunctionalInterface
    interface ProductCreator {
        Product create(String name, double price, String color);
    }

    private static final Map<String, ProductCreator> operationMap = new HashMap<>();

    static {
        operationMap.put("laptop", Laptop::create);
        operationMap.put("phone", Phone::create);
    }

    public static Product create(String type, String name, double price, String color) {
        return operationMap.get(type).create(
                name,
                price,
                color
        );
    }
}
