/**
 * Created by tianze
 * 2018/11/20 20:18
 */
public class maxArea {
    public static int maxArea(int[] height) {
        int max = 0;
        int temp = 0;

        int low = 0,high = height.length-1;

        while(low<high){
            temp = Math.min(height[low],height[high])*(high-low);
            max = Math.max(temp,max);
            if(height[low]<height[high]){
                low++;
            }
            else{
                high--;
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
