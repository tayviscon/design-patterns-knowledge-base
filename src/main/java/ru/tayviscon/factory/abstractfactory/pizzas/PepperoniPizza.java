package ru.tayviscon.factory.abstractfactory.pizzas;

import ru.tayviscon.factory.abstractfactory.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza {


	public PepperoniPizza(PizzaIngredientFactory pizzaIngredientFactory) {
		super(pizzaIngredientFactory);
	}

	public void prepare() {
		System.out.println("Preparing " + name);
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		veggies = pizzaIngredientFactory.createVeggies();
		pepperoni = pizzaIngredientFactory.createPepperoni();
	}
}
