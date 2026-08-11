package revision.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(candidates,0, target,path,ans);
        return ans;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> ans) {
        if(target == 0){
            ans.add(new ArrayList<>(path));
        }

        if(target < 0){
            return;
        }
        for(int i = index; i < candidates.length ; i++){
            if(i> index  && candidates[i] == candidates[i-1]){
                continue;
            }

            // choose
            path.add(candidates[i]);

            // explore
            dfs(candidates, i, target - candidates[i], path,ans);

            // undo
            path.remove(path.size() - 1);
        }

    }

}
