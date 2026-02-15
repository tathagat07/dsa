package dev.lpa;

public class ReverseArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        int[] reversed = reverseUsingWhile(numbers);
        for (int i : reversed) {
            System.out.println(i);
        }
    }


    public static int[] reverseUsingWhile(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
      return arr;
    }


}
