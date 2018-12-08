/**
 * Created by tianze
 * 2018/12/8 16:17
 */
public class Fibonacci {
    public static int Fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int first = 0;
        int second = 1;

        for(int i = 2; i<n;i++){
            int temp = first+second;
            first = second;
            second = temp;
        }

        return first+second;
    }
}
