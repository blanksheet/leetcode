/**
 * Created by tianze
 * 2019/5/13 15:01
 */
public class uniquePaths {

    //Time Limit Exceeded
    int count = 0;
    public int uniquePaths(int m, int n) {
        if(m < 0 || n < 0){
            return 0;
        }

        int[][] map = new int[m][n];

        helper(map, 0, 0, m, n);
        return count;
    }

    private void helper(int[][] map, int row, int col, int m, int n){
        if(row == m - 1 && col  == n - 1){
            count++;
            return;
        }

        if(col + 1 < n && map[row][col + 1] != 1){
            helper(map, row, col + 1, m, n);
        }

        if(row + 1 < m && map[row + 1][col] != 1){
            helper(map, row + 1, col,m ,n);
        }
    }

    public int uniquePaths2(int m, int n) {
        if(m < 0 || n < 0){
            return 0;
        }

        int[] cal = new int[n];
        cal[0] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                cal[j] += cal[j - 1];
            }
        }

        return cal[n - 1];
    }

}
