/**
 * Created by tianze
 * 2019/1/5 16:38
 */
public class Add {
    public int Add(int num1,int num2) {
        while( num2 != 0 ){
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }
}
