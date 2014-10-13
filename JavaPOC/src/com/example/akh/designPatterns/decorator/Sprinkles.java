package com.example.akh.designPatterns.decorator;

//Decorator Sprinkles that mixes sprinkles with coffee.
//Note it extends CoffeeDecorator.
class Sprinkles extends CoffeeDecorator {
	
	public Sprinkles (Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	public double getCost() {
		return super.getCost() + 0.2;
	}

	public String getIngredients() {
		return super.getIngredients() + ingredientSeparator + "Sprinkles";
	}
}