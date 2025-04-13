package com.thedevhorse.factory;

public class Laptop implements Product {

    private String name;
    private double price;
    private String color;

    private Laptop(String name,
                   double price,
                   String color) {
        this.name = name;
        this.price = setPrice(price);
        this.color = color;
    }

    public static Product create(String name,
                                 double price,
                                 String color) {
        return new Laptop(
                name,
                price,
                color
        );
    }

    private double setPrice(double price) {
        return price * colorPrice();
    }

    private double colorPrice() {
        if (color.equalsIgnoreCase("black") || color.equalsIgnoreCase("blue")) {
            return 1.1;
        }
        return 1.5;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String color() {
        return color;
    }
}
