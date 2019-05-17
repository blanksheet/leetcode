/**
 * Created by tianze
 * 2019/5/16 17:08
 */
public class minPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        int[] cal = new int[col];

        for(int i = 0; i < row; i++) {
            cal[0] += grid[i][0];
            for (int j = 1; j < col; j++) {
                if (i == 0) {
                    cal[j] = grid[i][j] + cal[j - 1];
                } else {
                    cal[j] = Math.min(cal[j - 1], cal[j]) + grid[i][j];
                }
            }
        }

        return cal[col - 1];

    }
}
