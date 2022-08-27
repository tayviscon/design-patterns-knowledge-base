package ru.tayviscon.decorator;

public class Soy extends CondimentDecorator{

    public Soy(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return beverage.cost() + 0.54;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
