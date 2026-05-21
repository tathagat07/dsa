package dev.annotation;

public class Main {
    public static void main(String[] args) {


        System.out.println(new ChildClass().getClass().getAnnotation(MyCustomAnnotation.class));
    }
}
