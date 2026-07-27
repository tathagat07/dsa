package patternbased.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

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
        }
        // Invalid path
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicate branches
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }

            // Choose
            path.add(candidates[i]);
            // Reuse the same number if needed
            dfs(candidates,
                    i + 1,
                    target - candidates[i],
                    path,
                    answer);
            // backtracking
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        CombinationSum2 solver = new CombinationSum2();

        int[] candidates = {1,1,2};
        int target = 2;

        List<List<Integer>> result = solver.combinationSum2(candidates, target);

        System.out.println("Candidates: " + Arrays.toString(candidates));
        System.out.println("Target: " + target);
        System.out.println("Combinations: " + result);
    }
}
