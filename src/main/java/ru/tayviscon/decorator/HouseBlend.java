package ru.tayviscon.decorator;

public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "HouseBlend";
    }

    public double cost() {
        return 1.32;
    }
}
