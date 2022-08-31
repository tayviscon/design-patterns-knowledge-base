package ru.tayviscon.factory.abstractfactory;

import ru.tayviscon.factory.abstractfactory.ingredients.cheese.Cheese;
import ru.tayviscon.factory.abstractfactory.ingredients.cheese.ReggianoCheese;
import ru.tayviscon.factory.abstractfactory.ingredients.clams.Clams;
import ru.tayviscon.factory.abstractfactory.ingredients.clams.FreshClams;
import ru.tayviscon.factory.abstractfactory.ingredients.dough.Dough;
import ru.tayviscon.factory.abstractfactory.ingredients.dough.ThinCrustDough;
import ru.tayviscon.factory.abstractfactory.ingredients.pepperoni.Pepperoni;
import ru.tayviscon.factory.abstractfactory.ingredients.pepperoni.SlicedPepperoni;
import ru.tayviscon.factory.abstractfactory.ingredients.sauce.MarinaraSauce;
import ru.tayviscon.factory.abstractfactory.ingredients.sauce.Sauce;
import ru.tayviscon.factory.abstractfactory.ingredients.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
