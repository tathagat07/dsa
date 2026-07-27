package patternbased.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, path, ans);

        return ans;
    }

    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> path,
                     List<List<Integer>> ans) {

        // One permutation is complete
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every unused number
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 &&
                    nums[i] == nums[i - 1] &&
                    !visited[i - 1]) {
                continue;
            }

            // Choose
            visited[i] = true;
            path.add(nums[i]);

            // Explore
            dfs(nums, visited, path, ans);

            // Undo
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation2 permutation2 = new Permutation2();
        int[] nums = {1, 1, 2};

        List<List<Integer>> result = permutation2.permute(nums);

        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Combinations: " + result);
        System.out.println("No of elements: " + result.size());
    }
}
