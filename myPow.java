/**
 * Created by tianze
 * 2018/12/22 21:14
 */
public class myPow {
    public double myPow(double x, int n) {
        boolean isNegative = false;

        if(n == 0 && x != 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        if(x == 0 && n <=0){
            System.out.println("求倒数出错");
        }
        if(x == 0 && n > 0){
            return 0;
        }

        if(n < 0){              //负数次幂
            isNegative = true;
            n = -n;
        }

        double result = myPow(x,n>>1);
        result *= result;

        if((n & 1) == 1){       //奇数次幂
            result *= x;
        }

        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return 0.0;
        }
        return isNegative ? 1 / result : result;

    }
}
