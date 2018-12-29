import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tianze
 * 2018/12/28 20:32
 */
public class largestRectangleArea {
    //O(n2)
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        if(heights.length == 1){
            return heights[0];
        }
        int max = 0;

        for(int i = 0; i < heights.length; i++){
            int left = i;
            int right = i;

            while(left >= 0){
                left--;
                if(left == -1){
                    left++;
                    break;
                }
                if(heights[left] < heights[i]){
                    left++;
                    break;
                }
            }

            while (right < heights.length){
                right++;
                if(right == heights.length){
                    right--;
                    break;
                }
                if(heights[right] < heights[i]){
                    right--;
                    break;
                }
            }

            max = Math.max(max, heights[i] * (right - left + 1));
        }

        return max;
    }

    public static int largestRectangleArea2(int[] heights){
        if(heights == null || heights.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for(int i = 0; i < heights.length; i++){
            while (!stack.empty() && heights[i] < heights[stack.peek()]){
                int temp = stack.pop();
                if(stack.empty()){
                    max = Math.max(heights[temp] * i,max);
                }
                else {
                    max = Math.max(heights[temp] * (i - stack.peek() - 1),max);
                }

            }
            stack.push(i);
        }

        while (!stack.empty()){
            int temp = stack.pop();
            if(stack.empty()){
                max = Math.max(heights[temp] * heights.length,max);
            }
            else {
                max = Math.max(heights[temp] * (heights.length - stack.peek() - 1),max);
            }

        }

        return max;
    }

    public static void main(String[] args){
        int[] array = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(array));
    }
}
