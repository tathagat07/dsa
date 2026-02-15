package dev.factoryPattern;

public class ShapeFactory {
    Shape getShape(String input){
        if(input == null){
            return null;
        }
        if(input.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(input.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}
