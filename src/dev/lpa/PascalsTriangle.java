package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(6);
        System.out.println(Arrays.deepToString(triangle.toArray()));

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        triangle.add(list);
        if(numRows ==1)
        {

        } else if (numRows == 2){
            List<Integer> li = new ArrayList<>();
            li.add(1);
            li.add(1);
            triangle.add(li);

        } else {
            List<Integer> li = new ArrayList<>();
            li.add(1);
            li.add(1);
            triangle.add(li);
            for (int i = 2; i< numRows ; i++){
                List<Integer> row = new ArrayList<>();
                row.add(1);
                int prevRowSize = triangle.get(i-1).size();
                for (int j = 0; j<prevRowSize-1; j++){
                  {
                        row.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j+1));

                  }
                }
                row.add(1);
                triangle.add(row);
            }
        }

        return triangle;
    }
}
