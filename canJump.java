/**
 * Created by tianze on 2019/4/12.
 */
public class canJump {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int global = 0;

        for(int i = 0; i <= global && i < nums.length; i++){
            global = Math.max(global, nums[i] + i);
        }

        if(global < nums.length - 1){
            return false;
        }
        return true;
    }
}
