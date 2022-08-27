package ru.tayviscon.decorator;

public class Milk extends CondimentDecorator{

    public Milk(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 1.92;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
