package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(500);

        Stream<Integer> numString = list.stream().filter((Integer c) -> c % 2 == 0).peek(System.out::println);
//        long count = numString.count();
//        System.out.println("No of even numbers in the list: " + count);

        List<String> name = new ArrayList<>();
        name.add("TATHAGAT");
        name.add("UMA");
        name.add("GOLU");

       // name.stream().map(s-> s.toLowerCase()).forEach(System.out::println);
//        Stream<String> name2 = name.map(s -> s.toUpperCase());
//        List list = name2.collect(Collectors.toList());
//        list.forEach(System.out::println);

        Integer[] numbers = {33,33,6,5,4, 5,1, 2, 3, 3};

    //    Arrays.stream(numbers).limit(3).collect(Collectors.toList()).forEach(System.out::println);
    //    Arrays.stream(numbers).distinct().sorted((Integer a , Integer b ) -> b -a).forEach(System.out::println);
   //     List<Integer> list2 = stream.collect(Collectors.toList());
     //   list2.forEach(System.out::println);

        List<Integer> list3 = Arrays.asList(12,13,14,15,16);
        Stream<Integer> stream = list3.stream()
                .filter((Integer c) -> c >= 12 )
                .peek((Integer c) -> System.out.println("Filtered value: " + c))
                .map((Integer c) -> c * 2)
                .peek((Integer c) -> System.out.println("After multiplying value: " + c))
                .sorted((Integer a, Integer b) -> b - a)
                .peek((Integer c) -> System.out.println("Sorted value: " + c));

        List<Integer> list4 = stream.collect(Collectors.toList());

    }
}
