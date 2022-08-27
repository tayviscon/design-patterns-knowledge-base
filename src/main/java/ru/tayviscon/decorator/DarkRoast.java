package ru.tayviscon.decorator;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    public double cost() {
        return 3.45;
    }
}
