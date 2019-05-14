/**
 * Created by tianze
 * 2019/5/14 15:26
 */
public class uniquePathsWithObstacles {
    //Time Limit Exceeded
    static int count = 0;
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if(row <= 0 || col <= 0){
            return 0;
        }

        if(row == 1 || col == 1){
            return obstacleGrid[0][0] == 1 ? 0 : 1;
        }

        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        helper(obstacleGrid, 0, 0, row, col);

        return count;
    }

    private static void helper(int[][] map, int row, int col, int m, int n){
        if(row == m - 1 && col  == n - 1 && map[row][col] != 1){
            count++;
            return;
        }
        if(row == m - 1 && col  == n - 1 && map[row][col] == 1){
            return;
        }

        if(col + 1 < n && map[row][col + 1] != 1){
            map[row][col] = 1;
            helper(map, row, col + 1, m, n);
            map[row][col] = 0;
        }

        if(row + 1 < m && map[row + 1][col] != 1){
            map[row][col] = 1;
            helper(map, row + 1, col,m ,n);
            map[row][col] = 0;
        }

        return;
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[] cal = new int[col];
        cal[0] = 1;


        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                cal[0] = 0;
            }
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 0){
                    cal[j] += cal[j - 1];
                }
                else {
                    cal[j] = 0;
                }
            }
        }

        return cal[col - 1];
    }

    public static void main(String[] args){
        int[][] test = {{0,1}};
        uniquePathsWithObstacles2(test);
    }

}
