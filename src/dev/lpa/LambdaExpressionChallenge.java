package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class LambdaExpressionChallenge {

    public static Random random = new Random();
    public static void main(String[] args) {
     String[] names = {"Anna","Bob","Ralph", "Alice", "Trixie", "Norton"};
      //  Arrays.sort(names, String::compareTo);
        System.out.println(Arrays.toString(names));
        System.out.println("Transforming to UpperCase-------");
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println(Arrays.toString(names));


    }
}
