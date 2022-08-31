package ru.tayviscon.factory.abstractfactory;

import ru.tayviscon.factory.abstractfactory.ingredients.cheese.Cheese;
import ru.tayviscon.factory.abstractfactory.ingredients.clams.Clams;
import ru.tayviscon.factory.abstractfactory.ingredients.dough.Dough;
import ru.tayviscon.factory.abstractfactory.ingredients.pepperoni.Pepperoni;
import ru.tayviscon.factory.abstractfactory.ingredients.sauce.Sauce;
import ru.tayviscon.factory.abstractfactory.ingredients.veggies.Veggies;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();
}
