import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by tianze on 2019/4/11.
 */
public class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null ||  nums.length <= 0){
            return result;
        }

        helper(nums, new boolean[nums.length],new ArrayList<>(), result );
        return result;
    }

    private void helper(int[] nums, boolean[] flag, ArrayList<Integer> temp,List<List<Integer>> result){
        if(temp.size() == nums.length){
            if(!result.contains(new ArrayList<>(temp))){
                result.add(new ArrayList<>(temp));
                return;
            }
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(flag[i] == false){
                temp.add(nums[i]);
                flag[i] = true;
                helper(nums,flag,temp,result);
                flag[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null ||  nums.length <= 0){
            return result;
        }
        Arrays.sort(nums);
        helper2(nums, new boolean[nums.length],new ArrayList<>(), result );
        return result;
    }

    private void helper2(int[] nums, boolean[] flag, ArrayList<Integer> temp,List<List<Integer>> result){
        if(temp.size() == nums.length){
           // if(!result.contains(new ArrayList<>(temp))){
                result.add(new ArrayList<>(temp));
                return;
           // }
           // return;
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && !flag[i - 1] && nums[i] == nums[i - 1]){
                continue;
            }
            if(flag[i] == false){
                temp.add(nums[i]);
                flag[i] = true;
                helper(nums,flag,temp,result);
                flag[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
