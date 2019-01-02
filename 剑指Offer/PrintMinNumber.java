import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tianze
 * 2019/1/2 12:25
 */
public class PrintMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }

        String[] numberString = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            numberString[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });

        StringBuffer result = new StringBuffer();
        for(String num : numberString){
            result.append(num);
        }

        return result.toString();
    }

    public static void main(String[] args){
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
}
