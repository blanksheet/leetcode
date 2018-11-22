import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianze
 * 2018/11/22 11:25
 */
public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums.length==0){
            return result;
        }

        Arrays.sort(nums);

        for(int i = 0;i < nums.length;i++){
            if(i-1>=0 && nums[i]==nums[i-1]){
                continue;
            }

            int left=i+1, right=nums.length-1;
            int sum = 0;

            while(left<right){
                sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[right],nums[left]));
                    while (left + 1 < right && nums[left] == nums[left+1])
                        left++;
                    while (right -1 > left && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }

        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
