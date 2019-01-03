/**
 * Created by tianze
 * 2019/1/3 11:22
 */
public class GetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]){
            return -1;
        }

        int kIndex = helper(array, k + 1);
        int kLowIndex = helper(array,k);

        return  kIndex - kLowIndex;
    }

    private static int helper(int[] array, int k){
        int low = 0;
        int high = array.length;

        while (low < high){
            int mid = (high + low) >> 1;

            if(array[mid] < k){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,3,3,3,4,5};
        int result = GetNumberOfK(array,3);
        System.out.println(result);
    }

}
