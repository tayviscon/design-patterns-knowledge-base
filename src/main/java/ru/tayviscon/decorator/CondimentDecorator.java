package ru.tayviscon.decorator;

public abstract class CondimentDecorator extends Beverage {
    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    protected Beverage beverage;

    public abstract String getDescription();

}
