package com.thedevhorse.factory;

public class Phone implements Product {

    private String name;
    private double price;
    private String color;

    private Phone(String name,
                  double price,
                  String color) {
        this.name = name;
        this.price = setPrice(price, color);
        this.color = color;
    }

    /**
     * Factory method to create a Phone instance.
     *
     * @param name  the name of the phone
     * @param price the base price of the phone
     * @param color the color of the phone
     * @return a new Phone instance
     */
    public static Product create(String name,
                                 double price,
                                 String color) {
        return new Phone(
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
