/**
 * Created by tianze
 * 2019/1/7 20:18
 */
public class hasPath {

    //static boolean path = false;

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length == 0){
            return false;
        }

        char[][] data = new char[rows][cols];

        int i = 0, j = 0;

        for(char temp : matrix){
            data[i][j] = temp;
            j++;
            if(j == cols){
                i++;
                j = 0;
            }
        }

        int[][] flag = new int[rows][cols];

        for(int m = 0; m < rows; m++){
            for(int n = 0; n < cols; n++){
                if(data[m][n] == str[0]){
                    if(helper(data,flag, m, n, str,0)){
                        return true;
                    }
                }

            }
        }

        return false;
    }

    private static boolean helper(char[][] matrix, int[][] flag, int rows, int cols, char[] str, int index){
        if(index == str.length){
            //path = true;
            return true;
        }

        if(index > str.length){
            return false;
        }

        if(rows == -1 || cols == -1 || rows == matrix.length || cols == matrix[0].length || matrix[rows][cols] != str[index]){
            return false;
        }

        if(flag[rows][cols] == -1){
            return false;
        }

        flag[rows][cols] = -1;

        if(helper(matrix,flag, rows, cols - 1, str, index + 1)){
            return true;
        }
        if(helper(matrix,flag, rows, cols + 1, str, index + 1)){
            return true;
        }
        if(helper(matrix,flag, rows - 1, cols , str, index + 1)){
            return true;
        }
        if(helper(matrix,flag, rows + 1, cols , str, index + 1)){
            return true;
        }

        flag[rows][cols] = 0;

        return false;
    }

    public static void main(String[] args){
        String matrix = "ABCESFCSADEE";
        String str = "BCCED";
        System.out.println( hasPath(matrix.toCharArray(), 3,4,str.toCharArray()));
    }

}
