package ru.tayviscon.decorator;

public class Espresso extends Beverage{

    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 5.21;
    }
}
