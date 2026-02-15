package dev.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MajorityElement {

    public static void majority(int nums[]){

        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums.length;
         for(int i =0; i< n ; i++){
             if(map.containsKey(nums[i])){
                 map.put(nums[i], map.get(nums[i]) + 1);
             } else {
                 map.put(nums[i],1);
             }
         }

         for(int key : map.keySet()){
             if(map.get(key)> n/3){
                 System.out.println(key);
             }
         }

    }

    public static int[] findMissingAndRepeatedValues1(int[][] grid) {
        int[] result = new int[2];
        int n = grid.length;
        int a = 0;
        int b = 0;
        int actualSum  = 0;
        int expectedSum = 0;
        Set<Integer> set = new HashSet();
        for(int i = 0; i< n; i++){
            for(int j= 0; j< n ; j++ ){
                actualSum += grid[i][j];
                if(set.contains(grid[i][j])) {
                    a = grid[i][j];
                    result[0] = a;

                } else{
                    set.add(grid[i][j]);
                }
                set.add(grid[i][j]);
            }
        }

        expectedSum = (n*n)*(n*n +1)/2;
        b = expectedSum + a -  actualSum;
        result[1] = b;

        return result;
    }


    public static void main(String[] args) {
        int nums[] = {1,2};

        majority(nums);
    }
}
