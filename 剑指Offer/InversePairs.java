/**
 * Created by tianze
 * 2019/1/2 15:43
 */
public class InversePairs {
    public static int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int result = helper(array, 0, array.length - 1);

        return result;


    }

    private static int helper(int[] array, int left, int right){
        if(left == right){
            return 0;
        }

        int mid = (left + right) >> 1;
        int countLeft = helper(array, left, mid);
        int countRight = helper(array, mid + 1, right);

        int count = 0;
        int[] temp = new int[right - left + 1];
        int length = temp.length - 1;

        int leftStart = mid;
        int rightStart = right;

        while (leftStart >= left && rightStart > mid){
            if(array[leftStart] > array[rightStart]){
                count += rightStart - mid;
                temp[length] = array[leftStart];
                length--;
                leftStart--;

                if(count >= 1000000007)
                {
                    count %= 1000000007;
                }
            }
            else {
                temp[length] = array[rightStart];
                length--;
                rightStart--;
            }
        }

        while (leftStart >= left){
            temp[length] = array[leftStart];
            length--;
            leftStart--;
        }

        while (rightStart > mid){
            temp[length] = array[rightStart];
            length--;
            rightStart--;
        }

        for(int i : temp){
            array[left] = i;
            left++;
        }

        return (count + countLeft + countRight)%1000000007;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,0};
        System.out.println(InversePairs(array));
    }

}
