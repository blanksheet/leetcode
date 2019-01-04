import java.util.ArrayList;

/**
 * Created by tianze
 * 2019/1/4 16:34
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(sum <= 2){
            return result;
        }

        int[] array = new int[sum/2 + 1];

        for(int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }

        int low = 0;
        int high = 1;
        int temp = 3;

        while (high < array.length){
            if(temp == sum){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int i = low; i <= high; i++){
                    arrayList.add(array[i]);
                }
                result.add(arrayList);
                high++;
                temp += high + 1;
            }
            else if(temp < sum){
                high++;
                temp += high + 1;
            }
            else {
                temp -= (low + 1);
                low++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        FindContinuousSequence(15);
    }
}
