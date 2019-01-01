/**
 * @Author: tianze
 * @Date: 2019/1/1 23:16
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }

        int count = 0;
        for(int i = 1; i <= n; i *= 10){
            int diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}
