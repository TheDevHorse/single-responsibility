package com.thedevhorse.factory;

public class Laptop implements Product {

    private final String name;
    private final double price;
    private final String color;

    private Laptop(String name,
                   double price,
                   String color) {
        this.name = name;
        this.price = setPrice(price, color);
        this.color = color;
    }

    /**
     * Factory method to create a Laptop instance.
     *
     * @param name  the name of the laptop
     * @param price the base price of the laptop
     * @param color the color of the laptop
     * @return a new Laptop instance
     */
    public static Product create(String name,
                                 double price,
                                 String color) {
        return new Laptop(
                name,
                price,
                color
        );
    }

    private double setPrice(double price, String color) {
        return price * colorPrice(color);
    }

    private double colorPrice(String color) {
        if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("red")) {
            return 2;
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
