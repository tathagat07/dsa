package dev.recursion;

import java.util.HashSet;

public class Recursion {
    public static boolean[] map = new boolean[26];

    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void removeDuplicates(String str, int idx, String newString){

        if(idx == str.length()){
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(idx);
        if(map[currentChar - 'a']){
            // duplicate
            removeDuplicates(str, idx + 1, newString);
        } else {
            newString += currentChar;
            map[currentChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newString);
        }

    }

    public static void printComb(String str, int idx, String combination){
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }

        char currentChar = str.charAt(idx);
        String mapping = keypad[currentChar -'0'];

        for(int i = 0 ; i< mapping.length();i++){
            printComb(str,idx+1,combination+ mapping.charAt(i));
        }

    }

    public static void subsequences(String str, int idx, String newString, HashSet<String> set) {

        if (idx == str.length()) {
            if (set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
            char currentChar = str.charAt(idx);

            subsequences(str, idx + 1, newString + currentChar, set);
            subsequences(str, idx + 1, newString, set);
        }


    public static void main(String[] args) {
      String str = "abbccda";
      String str2 = "aaa";
        HashSet<String> set = new HashSet<>();
   //   removeDuplicates(str,0,"");
    //    subsequences(str2,0,"",set);
        printComb("4",0,"");
    }
}
