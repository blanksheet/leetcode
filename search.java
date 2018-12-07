/**
 * Created by tianze
 * 2018/12/7 21:02
 */
public class search {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (right + left)/2;

            if(target == nums[mid]){
                return mid;
            }

            if(nums[mid] < nums[right]){   //m - right is sorted
                if(target > nums[mid] && target <=nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            else {     //left - mid is sorted
                if(target >= nums[left] && target <nums[mid]){
                    right = mid - 1;
                }
                else{
                    left =mid + 1;
                }
            }

        }

        return -1;
    }
}
