package com.ak.designPatterns.decorator;

//Abstract decorator class - note that it extends Coffee abstract class
public class CoffeeDecorator extends Coffee {
	
	protected final Coffee decoratedCoffee;
	protected String ingredientSeparator = ", ";

	protected CoffeeDecorator (Coffee decoratedCoffee) {
		this.decoratedCoffee = decoratedCoffee;
	}

	public double getCost() { // Implementing methods of the abstract class
		return decoratedCoffee.getCost();
	}

	public String getIngredients() {
		return decoratedCoffee.getIngredients();
	}
}
