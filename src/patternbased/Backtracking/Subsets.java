package patternbased.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, path, ans);

        return ans;
    }

    private void dfs(int[] nums,
                     int index,
                     List<Integer> path,
                     List<List<Integer>> ans) {
        // Every node is a valid subset
        ans.add(new ArrayList<>(path));
        // Try every remaining number
        for (int i = index; i < nums.length; i++) {
            // Choose
            path.add(nums[i]);
            // Explore
            dfs(nums, i + 1, path, ans);
            // Undo choice (Backtrack)
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        Subsets solver = new Subsets();

        // Input array
        int[] nums = {1, 2, 3};

        // Generate subsets
        List<List<Integer>> result = solver.subset(nums);

        // Output results
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Total Subsets: " + result.size());
        System.out.println("Subsets: " + result);
    }


}
