package ru.tayviscon.factory.abstractfactory.pizzas;

import ru.tayviscon.factory.abstractfactory.PizzaIngredientFactory;
import ru.tayviscon.factory.abstractfactory.ingredients.cheese.Cheese;
import ru.tayviscon.factory.abstractfactory.ingredients.clams.Clams;
import ru.tayviscon.factory.abstractfactory.ingredients.dough.Dough;
import ru.tayviscon.factory.abstractfactory.ingredients.pepperoni.Pepperoni;
import ru.tayviscon.factory.abstractfactory.ingredients.sauce.Sauce;
import ru.tayviscon.factory.abstractfactory.ingredients.veggies.Veggies;

public abstract class Pizza {

    protected final PizzaIngredientFactory pizzaIngredientFactory;

    public Pizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clams;


    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
