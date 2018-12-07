import java.util.Arrays;

/**
 * Created by tianze
 * 2018/12/7 20:20
 */
public class minNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        int res  = 0;

        while(array[left] >= array[right]){
            if(left == (right -1)){
                res = right;
                break;
            }

            int mid = (right + left)/2;

            //if index of left mid right number is equal then search one by one
            if(array[left] == array[mid] && array[left] == array[right]){
                Arrays.sort(array);
                return array[0];
            }

            if(array[left] <= array[mid]){
                left = mid;
            }
            else {
                right = mid;
            }

        }

        return array[res];
    }

    public static void main(String[] args){
        int[] array = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(array));
    }
}
