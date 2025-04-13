package com.thedevhorse.factory;

public class Phone implements Product {

    private String name;
    private double price;
    private String color;

    private Phone(String name,
                  double price,
                  String color) {
        this.name = name;
        this.price = setPrice(price);
        this.color = color;
    }

    public static Product create(String name,
                                 double price,
                                 String color) {
        return new Phone(
                name,
                price,
                color
        );
    }


    private double setPrice(double price) {
        return price * colorPrice();
    }

    private double colorPrice() {
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
