package dev.lpa;

public class Pattern10 {
    static void pattern7(int N){
        // This is the outer loop which will loop for the rows.
        // This is the outer loop which will loop for the rows.
        for (int i = 0; i < N-1; i++)
        {
            // This is the inner loop which here, loops for the columns
            // as we have to print a rectangular pattern.
            for (int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }

            // As soon as N stars are printed, we move to the
            // next row and give a line break otherwise all stars
            // would get printed in 1 line.
            System.out.println();
        }
    }
    static void pattern9(int N)
    {
        // This is the outer loop which will loop for the rows.
        for (int i = N-1; i >= 0; i--)
        {
            // This is the inner loop which here, loops for the columns
            // as we have to print a rectangular pattern.
            for (int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }

            // As soon as N stars are printed, we move to the
            // next row and give a line break otherwise all stars
            // would get printed in 1 line.
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Here, we have taken the value of N as 5.
        // We can also take input from the user.
        int N = 5;
        pattern7(N);
        pattern9(N);
    }
}
