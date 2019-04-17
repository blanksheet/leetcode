import java.util.ArrayList;

/**
 * @Author: tianze
 * @Date: 2019/4/17 22:06
 */
public class getPermutation  {
    public String getPermutation(int n, int k) {
        if(n <= 0){
            return "";
        }

        k--;
        StringBuffer res = new StringBuffer();
        int factorial = 1;
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 2; i < n; i++){
            factorial *= i;
        }
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }

        int round = n - 1;

        while (round >= 0){
            int index = k / factorial;
            k = k % factorial;

            res.append(nums.get(index));
            nums.remove(index);
            if(round > 0){
                factorial = factorial / round;
            }
            round--;
        }
        return res.toString();
    }

}
