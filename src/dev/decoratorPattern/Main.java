package dev.decoratorPattern;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new MargheritaPizza()));
        System.out.println("Final Pizza Cost: " + pizza.cost());
    }
}
