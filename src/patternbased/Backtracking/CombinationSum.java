package patternbased.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(candidates, 0, target, path, answer);
        return answer;
    }

    private void dfs(int[] candidates,
                     int index,
                     int target,
                     List<Integer> path,
                     List<List<Integer>> answer) {

        // Found a valid combination
        if (target == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        // Invalid path
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Choose
            path.add(candidates[i]);
            // Reuse the same number if needed
            dfs(candidates,
                    i,
                    target - candidates[i],
                    path,
                    answer);
            // Backtrack
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = solver.combinationSum(candidates, target);

        System.out.println("Candidates: " + Arrays.toString(candidates));
        System.out.println("Target: " + target);
        System.out.println("Combinations: " + result);
    }
}
