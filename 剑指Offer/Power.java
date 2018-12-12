/**
 * Created by tianze
 * 2018/12/11 16:27
 */
public class Power {
    public double Power(double base, int exponent) throws Exception {
        boolean flag = true;

        if(exponent == 0 && base != 0){
            return 1;
        }

        if(exponent == 1){
            return base;
        }

        if(base == 0 && exponent <=0){
            throw new Exception("0 求倒数出错");
        }
        if(base == 0 && exponent > 0){
            return 0;
        }

        if(exponent < 0){
            flag = false;
            exponent = -exponent;
        }


        double result = Power(base,exponent>>1);
        result *= result;

        if((exponent &  1) == 1){
            result *= base;
        }

        return flag ? result : 1/result;
    }

}
