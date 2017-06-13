package com.ak.designPatterns.decorator;

//Decorator Whip that mixes whip with coffee.
//Note it extends CoffeeDecorator.
class Whip extends CoffeeDecorator {
	
	public Whip (Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	public double getCost() {
		return super.getCost() + 0.7;
	}

	public String getIngredients() {
		return super.getIngredients() + ingredientSeparator + "Whip";
	}
}
