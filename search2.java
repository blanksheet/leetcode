/**
 * Created by tianze
 * 2018/12/11 15:05
 */
public class search2 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid  = left + (right - left) / 2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] > nums[left]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(nums[mid] < nums[left]){
                if(target >=nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                left++;
            }
        }
        return false;

    }
}
