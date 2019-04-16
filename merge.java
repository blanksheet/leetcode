import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tianze on 2019/4/16.
 */
public class merge {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);

        int col = intervals.length;
        List<int[]> result = new ArrayList();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < col; i++){
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1], end);
            }
            else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[]{start, end});

        int[][] returnArray = new int[result.size()][2];
        result.toArray(returnArray);
        return returnArray;
    }
}
