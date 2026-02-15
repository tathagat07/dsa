package dev.decoratorPattern;

public class Mushroom extends ToppingDecorator{
    private BasePizza pizza;

    public Mushroom(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    int cost() {
        return pizza.cost() + 15;
    }
}
