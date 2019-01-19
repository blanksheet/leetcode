import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianze
 * 2019/1/19 16:06
 */
public class combinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }

        Arrays.sort(candidates);

        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void helper(int[] candidates, int start, int target,ArrayList<Integer> item, List<List<Integer>> result){
        if(target < 0){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            item.add(candidates[i]);
            helper(candidates, i, target - candidates[i], item, result);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] candidates = {2,3,5};
        combinationSum(candidates,8);
    }
}
