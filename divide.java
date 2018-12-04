/**
 * Created by tianze
 * 2018/12/4 13:49
 */
public class divide {
    public static int divide(int dividend, int divisor) {
        if(divisor == 0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){ //deal with -MIN is still MIN
            return Integer.MAX_VALUE;
        }

        boolean flag = false;

        if((dividend > 0 && divisor >0)||
                (dividend < 0 && divisor < 0)){
            flag = true;
        }

        long dividenCal = Math.abs((long)dividend);
        long divisorCal = Math.abs((long)divisor);

        if(divisorCal == 1){
            return flag? (int)dividenCal:(int)-dividenCal;
        }

        long ret = 0;

        while (dividenCal >= divisorCal){
            long temp = divisorCal;
            long res = 1;
            while(dividenCal >= (temp<<1)){ //if dividencal is max than temp square  then res to res square
                temp<<=1;
                res<<=1;
            }
            ret += res;
            dividenCal -= temp;
        }

        return flag? (int)ret : (int)-ret;

    }




    public static void main(String[] args){
        System.out.println(divide(-2147483648,-1));
    }
}
