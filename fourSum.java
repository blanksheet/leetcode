import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianze
 * 2018/11/23 10:46
 */
public class fourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(nums==null || nums.length<4){
            return result;
        }

        if(nums.length==4){
            if(nums[0]+nums[1]+nums[2]+nums[3]==target){
                result.add(Arrays.asList(nums[0],nums[1],nums[2],nums[3]));
                return result;
            }
        }

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            if(i-1>=0 && nums[i]==nums[i-1]){
                continue;
            }

            for(int j = i+1;j < nums.length;j++){

                int left=j+1, right=nums.length-1;
                int sum =0;

                while(left<right){
                    if(left==i){
                        left++;
                        break;
                    }
                    if(right==i){
                        right--;
                        break;
                    }

                    sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){

                        if(!result.contains(Arrays.asList(nums[i],nums[j],nums[left],nums[right]))){
                            result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        }

                        while (left + 1 < right && nums[left] == nums[left+1])
                            left++;
                        while (right -1 > left && nums[right] == nums[right-1])
                            right--;
                        left++;
                        right--;
                    }
                    else if(sum>target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args){
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] num2 = {-3,-2,-1,0,0,1,2,3};
       // System.out.println(fourSum(nums,-1));
        System.out.println(fourSum(num2,0));
    }
}
