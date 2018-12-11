/**
 * Created by tianze
 * 2018/12/10 17:03
 */
public class mySqrt {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x ==1){
            return 1;
        }

        long left = 0;
        long right = x/2;

        while (left <= right){
            long mid = (left + right) / 2;

            if(x == mid * mid){
                return (int)mid;
            }
            else if(x > mid * mid){
                left = mid + 1 ;
            }
            else {
                right = mid - 1;
            }
        }

        return (int)left - 1;
    }

    public static int mySqrt2(int x){
        if(x == 0){
            return 0;
        }
        if(x ==1){
            return 1;
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(mid == x / mid){
                return mid ;
            }
            else if(mid < x / mid){
                left = mid + 1 ;
            }
            else {
                right = mid - 1;
            }
        }

        return left - 1;
    }

    public static void main(String[] args){
        mySqrt2(6);
    }

}
