import java.util.ArrayList;

/**
 * Created by tianze
 * 2019/1/14 19:35
 */
public class maxInWindows {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if(num.length < size || size == 0){
            return result;
        }

        int low = 0;
        int high = size - 1;
        int max = 0;

        max = findMax(low, high, num);

        while (high < num.length){
            result.add(max);

            high++;
            if(high == num.length){
                break;
            }

            max = Math.max(max, num[high]);

            if(num[low] == max){
                max = findMax(low + 1,high,num);
            }
            low++;
        }
        return result;
    }

    private static int findMax(int low, int high, int[] array){
        int max = 0;

        for(int i = low; i < high + 1; i++){
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] num = {2,3,4,2,6,2,5,1};
        maxInWindows(num,3);
    }
}
