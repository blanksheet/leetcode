/**
 * Created by tianze
 * 2018/12/10 16:53
 */
public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;


        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args){
        int[] test = {1,3,5,6};
        System.out.println(searchInsert(test,5)+" "+
                searchInsert(test,2));
        System.out.println(searchInsert(test,7)+" "+
                searchInsert(test,0));
    }
}
