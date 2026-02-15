package dev.string;

public class Substring {
    public static String userName(String str){

        int index = str.indexOf('@');
        return str.substring(0,index);


    }


    public static void main(String[] args) {
//        String input = "apnaCollegeJava@gmail.com";
//        String input2 = "helloWorlds123@gmail.com";
//
//        System.out.println(userName(input2));

//        StringBuilder sb = new StringBuilder("Tony");
//        sb.append(" Stark");
//        System.out.println(sb.reverse());

        StringBuilder sb = new StringBuilder("HelloWorld");

        for(int i=0; i<sb.length()/2; i++) {
            int front = i;
            int back = sb.length() - i - 1;


            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);


            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);
        }


        System.out.println(sb);


    }
}
