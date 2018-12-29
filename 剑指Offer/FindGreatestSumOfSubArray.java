/**
 * @Author: tianze
 * @Date: 2018/12/29 23:41
 */
public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return -1;
        }

        int curSum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if(curSum < 0){
                curSum = array[i];
            }
            else {
                curSum += array[i];
            }

            max = Math.max(curSum,max);
        }

        return max;
    }

    public static void main(String[] args){
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
