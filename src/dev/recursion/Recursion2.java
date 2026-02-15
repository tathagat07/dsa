package dev.recursion;

public class Recursion2 {

    public static  int first = -1;
    public static  int last = -1;

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n-1,src, dest, helper);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n-1,helper,src,dest);
    }

    public static void printRev(String str, int idx){
        if(idx ==0){
            System.out.print(str.charAt(idx));
            return;
        }


        System.out.print(str.charAt(idx));
        printRev(str, idx -1);
    }

    public static boolean isSorted(int arr[], int idx){
        if(idx == arr.length -1){
            return true;
        }

        if(arr[idx] >= arr[idx + 1]){
            return false;
        }
        return isSorted(arr, idx + 1);

    }

    public static void findOccurance(String str, int idx, char element){
        if(idx == str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currentChar = str.charAt(idx);

        if (currentChar == element){
            if(first == -1){
                first = idx;
            } else {
                last = idx;
            }
        }
        findOccurance(str, idx + 1, element);
    }

    public static void moveAllX(String str , int idx, int count, String newStr){
        if(idx == str.length()) {

            for (int i = 0; i < count; i++) {
                newStr += 'x';
            }
            System.out.println(newStr);
            return;

        }

        char currentChar = str.charAt(idx);
        if (currentChar =='x'){
            count++;
            moveAllX(str, idx + 1, count, newStr);
        } else {
            newStr += currentChar;
            moveAllX(str, idx + 1, count, newStr);
        }
    }

    public static void main(String[] args) {

//        int n = 4; // Number of disks
//        towerOfHanoi(n, "S", "H", "D"); // A, B and C are names of rods
//        }
        String str = "abcd";
        String str2 = "abaacdaefaah";
        String str3 = "axbcxxd";
        moveAllX(str3,0,0,"");
       // printRev(str,str.length()-1);
       // findOccurance(str2,0,'a');
      int arr[] = {1,2,3,4,4,5};
    //    System.out.println(isSorted(arr,0) );
    }

    }

