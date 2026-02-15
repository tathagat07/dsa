package dev.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTTPLogAnalyzer {

    public static void summary(String input) {

        Pattern pattern = Pattern.compile("INFO \\[(\\w+)\\] \\[(.*?)\\] \\[(\\d{3})\\] \\[(\\d+)ms\\]");
        Matcher matcher = pattern.matcher(input);
        Matcher matcher1 = pattern.matcher(input);
        HashMap<String,Integer> requestPerEndpoint = new HashMap<>();
        HashMap<String,Integer> averageResponse = new HashMap<>();
        TreeMap<String,Integer> slowestResponse = new TreeMap<>();
        int count = 1;
        int totalCalls = 0;
        int successCall = 0;
        int failedCalls = 0;

        while (matcher.find()) {
            String method = matcher.group(1);      // GET
            String path = matcher.group(2);        // /api/users
            String status = matcher.group(3);      // 200
            String time = matcher.group(4);        // 120
            int statusCode = Integer.parseInt(status);
            if((statusCode==200) || (statusCode==201) || (statusCode==204)){
                successCall+=1;
              }else {
                failedCalls+=1;
            }


            if(requestPerEndpoint.containsKey(path)){
                requestPerEndpoint.put(path,requestPerEndpoint.get(path)+1);

            } else {
                requestPerEndpoint.put(path,1);
            }

            if(averageResponse.containsKey(path)){
                averageResponse.put(path,(Integer.parseInt(time) + averageResponse.get(path))/++count);

            } else {
                averageResponse.put(path,Integer.parseInt(time));
            }


            slowestResponse.put(path,Integer.parseInt(time));

            System.out.println("INFO, " + method + ", " + path + ", " + status + ", " + time);
        }
        totalCalls = successCall + failedCalls;
        System.out.println("Requests per endpoint");
        for (Map.Entry str: requestPerEndpoint.entrySet()){
            System.out.println(str.getKey() +" : "+str.getValue());
        }
        System.out.println("Average Response time");
        for (Map.Entry str: averageResponse.entrySet()){
            System.out.println(str.getKey() +" : "+str.getValue());
        }
        System.out.println("Slowest call endpoint");

        for (Map.Entry str: slowestResponse.entrySet()){
            System.out.println(str.getKey() +" : "+str.getValue());
        }

        System.out.println("Error Rate:");

        System.out.println(failedCalls *100 / totalCalls + " %");

    }

    public static void main(String[] args) {
        String input = "INFO [GET] [/api/users] [200] [120ms] " +
                       "INFO [GET] [/api/orders] [404] [60ms]"+
                       "INFO [GET] [/api/users] [500] [95ms]"+
                       "INFO [GET] [/api/orders] [200] [180ms]+" +
                       "INFO [GET] [/api/orders] [200] [310ms]+" +
                       "INFO [OPTIONS] [/api/orders] [204] []+" +
                       "INFO [GET] [/api/users] [201] [180ms]+" ;
                ;

        summary(input);
        }






}
