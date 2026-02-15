package dev.functional_interface;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        Supplier<String> isEvenNumber = () -> {
//            return "Is even number";
//        } ;
//        System.out.println(isEvenNumber.get());

//        Function<Integer,String> integerToString = (Integer num) -> {
//          String output = num.toString();
//          return output;
//        };
//
//        System.out.println(integerToString.apply(2));

        Predicate<Integer> isEven = (Integer val) ->{
          return val % 2 == 0;
        };
        System.out.println(isEven.test(11));
    }
}
