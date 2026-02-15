package dev.reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class <?> eagleClass = Eagle.class;
//        Method[] methods = eagleClass.getDeclaredMethods();
//
//        for (Method methodsMethod : methods) {
//            System.out.println("Method Name: " + methodsMethod.getName());
//            System.out.println("Return Type: " + methodsMethod.getReturnType().getName());
//            System.out.print("Class name: "+methodsMethod.getDeclaringClass().getName());
//            System.out.println("\n");
//            System.out.println("**********");
//
//        }
        Eagle eagle = new Eagle();
        Field field = eagleClass.getDeclaredField("canSwim");
        field.setAccessible(true); // Allows access to private fields
        field.set(eagle, true); // Set the value of the private field
        if(field.getBoolean(eagle) ) {
            System.out.println("Eagle can swim");
        } else {
            System.out.println("Eagle cannot swim");
        }

    }
}
