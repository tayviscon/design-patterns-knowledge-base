package ru.tayviscon.factory.abstractfactory.pizzas;

import ru.tayviscon.factory.abstractfactory.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {
	public VeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
		super(pizzaIngredientFactory);
	}

	public void prepare() {
		System.out.println("Preparing " + name);
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		veggies = pizzaIngredientFactory.createVeggies();
	}
}
