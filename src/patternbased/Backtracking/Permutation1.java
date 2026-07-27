package patternbased.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation1 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,path,ans);

        return ans;
    }

    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> path,
                     List<List<Integer>> ans) {

        // One permutation is complete
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every unused number
        for(int i = 0 ; i <nums.length ; i++){
            if(visited[i]){
                continue;
            }

            // Choose
            visited[i] = true;
            path.add(nums[i]);

            // Explore
            dfs(nums,visited,path,ans);

            // Undo
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation1 permutation1 = new Permutation1();
        int[] nums = {1,1,2};

        List<List<Integer>> result = permutation1.permute(nums);

        System.out.println("Candidates: " + Arrays.toString(nums));
        System.out.println("Combinations: " + result);
        System.out.println("No of elements: " + result.size());
    }
}
