package dev.hashing;

import java.util.HashSet;

public class Union {

    public static int union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i< arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int j = 0; j< arr2.length; j++){
            set.add(arr2[j]);
        }

        return set.size();

    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3,5};
        int arr2[] = {1,2,3,5};

        int ans = union(arr1,arr2);
        System.out.println(ans);
    }
}
