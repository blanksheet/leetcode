import java.util.ArrayList;

/**
 * Created by tianze
 * 2018/11/14 12:23
 */
public class reverse {
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        ArrayList<Integer> save = new ArrayList<Integer>();
        int i = 0;
        int cal = x > 0 ? x : -x;

        while (cal > 0) {
            save.add(i, cal % 10);
            cal = cal / 10;
            i++;
        }
        int result = 0;

        for (int j = 0; j < i; j++) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && save.get(j) > 7))//溢出检测
                return 0;
            result = 10 * result + save.get(j);
        }
        return x > 0 ? result : -result;
    }

    public static void main(String[] args){
        int x1 = 123;
        int x2 = -123;
        int x3 = 120;
        int x4=1534236469;
       // System.out.println(reverse(x1));
       // System.out.println(reverse(x2));
       // System.out.println(reverse(x3));
        System.out.println(reverse(x4));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
