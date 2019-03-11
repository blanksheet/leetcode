/**
 * @Author: tianze
 * @Date: 2019/3/11 23:10
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int local = nums[0];
        int total = nums[0];

        for(int i =1; i < nums.length; i++){
            local = Math.max(nums[i],local+nums[i]);
            total = Math.max(local,total);
        }

        return total;
    }
}
