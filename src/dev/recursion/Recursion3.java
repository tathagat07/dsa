package dev.recursion;

public class Recursion3 {

    public static int countPaths(int i, int j, int m, int n){

        if(i == m || j == n){
            return 0;
        }

        if(i == m-1 && j == n-1){
            return 1;
        }

        int downPaths = countPaths(i+1,j,m,n);
        int rightPaths = countPaths(i,j+1,m,n);

        int totalPaths = downPaths + rightPaths;
        return totalPaths;
    }

    public static int placeTiles(int m, int n){
        if(m == n){
            return 2;
        }
        if(m < n){
            return 1;
        }
        // place vertically
        int horizontalWays = placeTiles(m-1,n);
        // place horizontally
        int  verticalWays = placeTiles(m-n,n);
        int totalWays = verticalWays + horizontalWays;
        return totalWays;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

    //    System.out.println(countPaths(0,0,m,n));
        System.out.println(placeTiles(4,2));
    }
}
