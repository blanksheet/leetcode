import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tianze
 * @Date: 2019/3/12 22:11
 */
public class permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        //helper(new ArrayList<>(), 0, nums.length, result, data);

        boolean[] flag = new boolean[nums.length];
        helper(new ArrayList<Integer>(), 0, nums, flag,result);
        return result;


    }

    private static void helper(ArrayList<Integer> temp, int index, int[] nums, boolean[] flag, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!flag[i]){
                flag[i] = true;
                temp.add(nums[i]);
                helper(temp, index + 1, nums, flag, result);
                temp.remove(temp.size() - 1);
                flag[i] = false;
            }
            //else {
            //    continue;
            //}
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        permute(nums);
    }

}
