/**
 * Created by tianze
 * 2018/12/30 16:59
 */
public class trap {
    public static int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int max = 0;
        int result = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        for(int i = 0; i < height.length; i++){
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }

        max = 0;
        int countEach = 0;
        for(int j = height.length - 1; j >= 0; j--){
            max = Math.max(max,height[j]);
            countEach = Math.min(max,leftMax[j]);
            result += countEach > height[j] ? countEach - height[j] : 0;
        }

       return result;
    }

    public static int trap2(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int min = Math.min(height[left], height[right]);

            if(height[left] == min){
                left++;
                while (left < right && height[left] < min){
                    result += min - height[left];
                    left++;
                }
            }
            else {
                right--;
                while (left < right && height[right] < min){
                    result += min - height[right];
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));
    }
}
