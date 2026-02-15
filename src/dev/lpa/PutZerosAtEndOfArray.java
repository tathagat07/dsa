package dev.lpa;

public class PutZerosAtEndOfArray {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1,0,1,0,1,2,2};
        int[] replaced = xyz(arr);
        for (int i : replaced) {
            System.out.println(i);
        }
    }

    public static int[] xyz(int arr[]) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;

        while (start <= end) {

            if (arr[start] == 0 && arr[end] !=0) {

                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;

            }

            else if (arr[start] == 1) {
                start++;

            }
            else if (arr[start] == 0) {
                end--;

            }

        }
        return arr;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

}


