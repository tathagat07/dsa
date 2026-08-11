package revision.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(nums,0,path,ans);

        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> ans) {

        // every node is a valid subset.
        ans.add(new ArrayList<>(path));

        for(int i = index ; i < nums.length; i++){
            // choose
            path.add(nums[i]);

            // explore
            dfs(nums,i+1,path,ans);

            // undo
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        patternbased.Backtracking.Subsets solver = new patternbased.Backtracking.Subsets();

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
