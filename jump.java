/**
 * Created by tianze on 2019/4/12.
 */
public class jump {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int step = 0;
        int previous = 0;
        int global = 0;

        for(int i = 0; i <= global && i < nums.length; i++){
            if(i > previous){
                step++;
                previous = global;
            }
            global = Math.max(global, nums[i] + i);
        }

        if(global < nums.length - 1){
            return 0;
        }

        return step;

    }
}
