/**
 * Created by tianze
 * 2018/11/29 16:05
 */
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
