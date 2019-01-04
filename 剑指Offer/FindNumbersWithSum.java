import java.util.ArrayList;

/**
 * Created by tianze
 * 2019/1/4 16:29
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array == null || array.length == 0 || sum < array[0]){
            return null;
        }

        ArrayList<Integer> result  = new ArrayList<>();

        int left = 0;
        int right = array.length - 1;

        while (left < right){
            if(array[left] + array[right] == sum){
                result.add(array[left]);
                result.add(array[right]);
                return result;
            }
            else if(array[left] + array[right] > sum){
                right--;
            }
            else {
                left++;
            }

        }

        return null;
    }
}
