package ru.tayviscon.templatemethod;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void brew();
    protected abstract void addCondiments();
    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void pourInCup(){
        System.out.println("pouring in Cap");
    }

}
