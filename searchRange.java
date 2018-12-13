/**
 * Created by tianze
 * 2018/12/13 19:49
 */
public class searchRange {
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        int low = 0;
        int high = nums.length - 1;
        boolean flag = false;
        int mid = 0;

        while(low <= high){
            mid  = low + (high - low) / 2;
            if(nums[mid] == target){
                flag = true;
                break;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        if(!flag){
            int[] notFound = {-1,-1};
            return notFound;
        }

        int left = mid;
        int right = mid;

        while(left > 0){
            if(nums[left - 1] == target){
                left--;
            }
            else {
                break;
            }
        }

        while(right < nums.length - 1 ){
            if(nums[right + 1] == target){
                right++;
            }
            else {
                break;
            }
        }

        int[] found = {left,right};
        return found;
    }

    public static int[] searchRange2(int[] nums, int target) {

        int left = searchFirstGreater(nums,target);

        if(left == nums.length || nums[left] != target){
            int[] notFound = {-1,-1};
            return notFound;
        }
        int right = searchFirstGreater(nums,target+1);

        int[] found = {left,right - 1};
        return found;
    }

    private static int searchFirstGreater(int[] nums, int target){
        int low = 0;
        int high = nums.length;           //because it is greater, so it should be nums.length
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args){
        int[] array = {1};
        searchRange2(array,1);
    }
}
