import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;

/**
 * Created by tianze
 * 2019/5/15 10:21
 */
public class insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int num = intervals.length;

        if(num == 0){
            int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];

            return result;
        }

        ArrayList<Integer> check = new ArrayList();


        int i = 0;

        while (i < num && intervals[i][1] < newInterval[0]){
            check.add(intervals[i][0]);
            check.add(intervals[i][1]);
            i++;
        }

        if(i < num){
            check.add(Math.min(intervals[i][0], newInterval[0]));
            int tempMax = newInterval[1];
            while (i < num && intervals[i][0] <= newInterval[1]){
                tempMax = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            check.add(tempMax);
        }

        while (i < num){
            check.add(intervals[i][0]);
            check.add(intervals[i][1]);
            i++;
        }

        if(intervals[num - 1][1] < newInterval[0]){
            check.add(newInterval[0]);
            check.add(newInterval[1]);
        }

        int count = check.size() / 2;
        int[][] result = new int[count][2];
        count = 0;

        for(int j = 0; j < check.size(); j += 2){
            result[count][0] = check.get(j);
            result[count][1] = check.get(j + 1);
            count++;
        }

        return result;
    }

    public static void main(String[] args){
        int[][] intervals = {{2,5}};
        int[] newInterval = {0,1};
        insert(intervals,newInterval);
    }
}
