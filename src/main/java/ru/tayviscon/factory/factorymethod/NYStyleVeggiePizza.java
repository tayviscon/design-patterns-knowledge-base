package ru.tayviscon.factory.factorymethod;

public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Mushroom Sauce";
        toppings.add("Vegetarian sauce");
    }
}
