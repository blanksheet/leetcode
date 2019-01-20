/**
 * Created by tianze
 * 2019/1/20 11:37
 */
public class firstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }

        int[] data = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < nums.length + 1 && nums[i] > 0 && data[nums[i] - 1] != nums[i]){
                data[nums[i] - 1] = nums[i];
            }
        }

        for(int i = 0; i < data.length; i++){
            if(i + 1 != data[i]){
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args){
        int[] nums = {1};
        firstMissingPositive(nums);
    }

}
