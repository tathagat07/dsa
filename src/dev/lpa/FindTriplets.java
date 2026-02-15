package dev.lpa;

public class FindTriplets {
    public static void main(String[] args) {
        int[] numbers = {1,1, 2,1, 2,3,3,3, 4, 5};
        System.out.println(findTriplet(numbers));
    }

    public static boolean findTriplet(int[] arr){

        boolean flag = false;
        for(int i = 0 ; i< arr.length-2; i++){
            int sum = 0;
            sum = (arr[i] ^ arr[i+1] ^ arr[i+2]);
          //  System.out.println(sum);
            if(sum == arr[i] && arr[i]== arr[i+1]){
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}
