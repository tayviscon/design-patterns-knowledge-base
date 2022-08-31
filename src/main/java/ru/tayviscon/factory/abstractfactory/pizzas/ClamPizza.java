package ru.tayviscon.factory.abstractfactory.pizzas;

import ru.tayviscon.factory.abstractfactory.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
	public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
		super(pizzaIngredientFactory);
	}

	public void prepare() {
		System.out.println("Preparing " + name);
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		clams = pizzaIngredientFactory.createClams();
	}
}
