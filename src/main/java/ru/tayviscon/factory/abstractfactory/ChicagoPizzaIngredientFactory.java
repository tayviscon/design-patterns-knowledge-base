package ru.tayviscon.factory.abstractfactory;

import ru.tayviscon.factory.abstractfactory.ingredients.cheese.Cheese;
import ru.tayviscon.factory.abstractfactory.ingredients.cheese.MozzarellaCheese;
import ru.tayviscon.factory.abstractfactory.ingredients.clams.Clams;
import ru.tayviscon.factory.abstractfactory.ingredients.clams.FrozenClams;
import ru.tayviscon.factory.abstractfactory.ingredients.dough.Dough;
import ru.tayviscon.factory.abstractfactory.ingredients.dough.ThickCrustDough;
import ru.tayviscon.factory.abstractfactory.ingredients.pepperoni.Pepperoni;
import ru.tayviscon.factory.abstractfactory.ingredients.pepperoni.SlicedPepperoni;
import ru.tayviscon.factory.abstractfactory.ingredients.sauce.PlumTomatoSauce;
import ru.tayviscon.factory.abstractfactory.ingredients.sauce.Sauce;
import ru.tayviscon.factory.abstractfactory.ingredients.veggies.BlackOlives;
import ru.tayviscon.factory.abstractfactory.ingredients.veggies.Eggplant;
import ru.tayviscon.factory.abstractfactory.ingredients.veggies.Spinach;
import ru.tayviscon.factory.abstractfactory.ingredients.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new BlackOlives(), new Spinach(), new Eggplant()};
    };

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
