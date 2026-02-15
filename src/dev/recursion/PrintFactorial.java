package dev.recursion;

public class PrintFactorial {

    public static void printFact(int n, int fact) {
        if (n == 0) {
            System.out.println(fact);
            return;
        }

        fact = fact * n;
        printFact(n - 1, fact);
    }

    public static void printFibonacci(int a, int b, int n) {
        if (n == 0) {
            return;
        }

        System.out.println(a);
        printFibonacci(b, b + a, n - 1);


    }


    public static int printPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        int x_ = printPower(x,n-1);
        int x_n = x_ * x;

        return x_n;


    }

    public static void main(String[] args) {
        // printFact(5,1);
       // printFibonacci(0, 1, 5);
        System.out.println(System.currentTimeMillis());
        int output = printPower(2,5);
        System.out.println(output);

    }
}
