/**
 * Created by tianze
 * 2019/1/5 16:35
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        if(n < 0){
            return -1;
        }

        return sum(n);
    }

    private int sum(int n){
      try{
          int flag = 1 / n;
          return n + sum(n - 1);
      }
      catch (Exception e){
          return 0;
      }

    }
}
