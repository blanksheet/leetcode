import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianze
 * 2019/1/20 10:53
 */
public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);

        helper(candidates, 0, target, new ArrayList(), result);
        return result;
    }

    private void helper(int[] candidates, int start, int target, ArrayList temp,List<List<Integer>> result){
        if(target < 0){
            return;
        }
        if(target == 0){
            //if(!result.contains(new ArrayList<>(temp))){
                result.add(new ArrayList<>(temp));
            //}
            return;
        }
        if(start == candidates.length){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            temp.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

}
