import javax.print.attribute.HashAttributeSet;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by tianze
 * 2019/1/22 11:33
 */
public class maxPoints {
    public class  Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    //O(n3)
    public static int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }

        int cur = 2;
        int max = 0;
        int duplicate = 1;

        for(int i = 0; i < points.length; i++){
            duplicate = 1;
            for(int j = i + 1; j < points.length; j++){
                cur = 2;

                long x1 = points[i].x, y1 = points[i].y;
                long x2 = points[j].x, y2 = points[j].y;

                if(x1 == x2 && y1 == y2){ // 如果两点相同，则判断失效
                    duplicate++;
                    continue;
                }

                for(int m = 0; m < points.length; m++){
                    long x3 = points[m].x, y3 = points[m].y;
                    if(i != m && j != m && (y2 - y1)*(x3 - x2) == (y3 - y2)*(x2 -x1)){
                        cur++;
                    }
                }

                max = Math.max(cur, max);
            }
            max = Math.max(duplicate,max);
        }

        return max;
    }

    //O(n2)
    public int maxPoints2(Point[] points){
        if(points == null || points.length == 0){
            return 0;
        }

        int max = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hashMap = new HashMap();
            int duplicate = 0;
            int localMax = 1;

            int x1 = points[i].x, y1 = points[i].y;
            for(int j = i + 1; j < points.length; j++){
                int x2 = points[j].x, y2 = points[j].y;
                double slope =  0;

                if(x1 == x2 && y1 == y2){
                    duplicate++;
                    continue;
                }

                if(x1 == x2){
                    slope = Double.MIN_VALUE;
                }
                if(y1 == y2){
                    slope = 0;
                }
                if(x1 != x2 && y1 != y2){
                    double temp1 = y1 - y2;
                    double temp2 = x1 - x2;
                    slope = temp1 / temp2;
                }

                if(hashMap.containsKey(slope)){
                    hashMap.put(slope, hashMap.get(slope) + 1);
                }
                else {
                    hashMap.put(slope,2);
                }
            }

            for(Integer value : hashMap.values()){
                localMax = Math.max(value,localMax);
            }

            localMax += duplicate;

            max = Math.max(localMax,max);

        }

        return max;
    }

    //针对double精度不够 使用BigDecimal
    public static int maxPoints3(Point[] points){
        if(points == null || points.length == 0){
            return 0;
        }

        int max = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<BigDecimal, Integer> hashMap = new HashMap();
            int duplicate = 0;
            int localMax = 1;

            int x1 = points[i].x, y1 = points[i].y;
            for(int j = i + 1; j < points.length; j++){
                int x2 = points[j].x, y2 = points[j].y;
                BigDecimal slope =  BigDecimal.valueOf(0);

                if(x1 == x2 && y1 == y2){
                    duplicate++;
                    continue;
                }

                if(x1 == x2){
                    slope = BigDecimal.valueOf(Integer.MAX_VALUE);
                }
                if(y1 == y2){
                    slope = BigDecimal.valueOf(0);
                }
                if(x1 != x2 && y1 != y2){
                    BigDecimal temp1 = new BigDecimal(y1 - y2);
                    BigDecimal temp2 = new BigDecimal(x1 - x2);
                    slope = temp1.divide(temp2,18, BigDecimal.ROUND_HALF_DOWN);
                }

                if(hashMap.containsKey(slope)){
                    hashMap.put(slope, hashMap.get(slope) + 1);
                }
                else {
                    hashMap.put(slope,2);
                }
            }

            for(Integer value : hashMap.values()){
                localMax = Math.max(value,localMax);
            }

            localMax += duplicate;

            max = Math.max(localMax,max);

        }

        return max;
    }

    public static void main(String[] args){
        int num1 = 0 - 65536;
        int num2 = 65536 - 1;
        //[[0,0],[94911151,94911150],[94911152,94911151]]
        int x1 = 94911151;
        int y1 = 94911150;
        int x2 = 94911152;
        int y2 = 94911151;

        double res1 = (double) (y2) / (double)(x2);
        double res2 = (double)(y1) / (double)(x1);

        long res = (long)num1 * num2;

        //使用int溢出 使用long数据
        System.out.println(num1 * num2);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        HashMap<Double, Integer> hashMap = new HashMap();
        hashMap.put(res1,2);
        System.out.println(hashMap.containsKey(res2));

    }



}
