package com.sutao.creator.builder;

//concrete builder
public class KFCMealBuilder implements IMealBuilder {
    private Meal meal;

    public KFCMealBuilder() {
        meal = new Meal();
    }

	@Override
	public void makeFood() {
        meal.setFood("make fried chicken.");
	}

	@Override
	public void makeDrink() {
        meal.setDrink("make apple juice.");
	}

	@Override
	public Meal getMeal() {
		return meal;
	}
}
