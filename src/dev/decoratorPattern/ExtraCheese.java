package dev.decoratorPattern;

public class ExtraCheese extends ToppingDecorator{
    private BasePizza pizza;

    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    int cost() {
        return pizza.cost() + 10;
    }
}
