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

        ArrayList<Integer> data = new ArrayList<>();

        for(int i : nums){
            data.add(i);
        }

        helper(new ArrayList<>(), 0, nums.length, result, data);

        return result;


    }

    private static void helper(ArrayList<Integer> temp, int index, int length, List<List<Integer>> result, ArrayList<Integer> data){
        if(index == length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < data.size(); i++){
            int tempInt = data.get(i);
            temp.add(tempInt);
            data.remove(i);
            helper(temp,index + 1, length, result, data);
            data.add(tempInt);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        permute(nums);
    }

}
