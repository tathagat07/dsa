package dev.functional_interface;

import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {

//        Predicate<Integer> isEven = (Integer number) -> {
//            if( number % 2 == 0)
//                return true;
//            else
//                return false;
//        };
//
//        System.out.println("Is 45 even? " + isEven.test(45));

//        Function<Integer, String> numToString =
//                (Integer number) -> {
//                    String output = String.valueOf(number);
//                    return output;
//                };
//
//        System.out.println("Number 45 as String: " + numToString.apply(45));

        Supplier<String> getString = () -> {
            return "Hello, World!";
        };

        System.out.println("Supplier output: " + getString.get());

    }
}
