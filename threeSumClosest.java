import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by tianze
 * 2018/11/22 15:30
 */
public class threeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int diff = Integer.MAX_VALUE;
        if(nums.length==0){
            return result;
        }

        LinkedList save = new LinkedList();
        Arrays.sort(nums);

        for(int i = 0;i < nums.length;i++){
            int left=i+1, right=nums.length-1;
            int sum = 0;

            while(left<right){
                sum = nums[i]+nums[left]+nums[right]-target;
                if(sum == 0){
                    left++;
                    right--;
                    return target;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    left++;
                }
                if(diff>Math.abs(sum)){
                    diff = Math.abs(sum);
                    result = target - sum*-1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums,1));
    }
}
