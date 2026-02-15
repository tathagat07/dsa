package dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;

public class LambdaChallenge {
    public static void main(String[] args) {

   //  String sentence = "Hello world I have arrived!";
//     var list = Arrays.asList(sentence.split(" "));
//        list.forEach(s -> System.out.println(s));

        Consumer<String> printWords = sentence1 -> {
            String[] words = sentence1.split(" ");
            for (String word : words) {
                System.out.println(word);
            }
        };

       Consumer<String> printWordsForEach = sentence -> {
           Arrays.asList(sentence.split(" ")).forEach(s-> System.out.println(s));
       };
        System.out.println("-------");
       printWordsForEach.accept("Hello world I have arrived");
    }
}
