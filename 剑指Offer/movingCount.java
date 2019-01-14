/**
 * Created by tianze
 * 2019/1/14 20:40
 */
public class movingCount {
    //static int count = 0;

    public static int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || (rows < 0 && cols < 0)){
            return 0;
        }

        int[][] flag = new int[rows][cols];

        helper(flag, 0, 0,threshold);

        int count = 0;
        for(int i = 0; i < rows ; i ++){
            for(int j = 0; j < cols; j ++){
                if(flag[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }

    private static void helper(int[][] array, int rows, int cols,int threshold){
        if(rows < 0 || cols < 0 || rows == array.length || cols == array[0].length || array[rows][cols] == 1){
            return;
        }
        if(!isVaild(rows, cols, threshold)){
            return;
        }

        array[rows][cols] = 1;
        helper(array,rows - 1, cols,threshold);
        helper(array,rows + 1, cols,threshold);
        helper(array,rows , cols - 1,threshold);
        helper(array,rows , cols + 1,threshold);
    }

    private static boolean isVaild(int rows, int cols , int threshold){
        int count = 0;

        while (rows != 0){
            count += rows % 10;
            rows = rows / 10;
        }

        while (cols != 0){
            count += cols % 10;
            cols = cols / 10;
        }

        return count <= threshold;
    }

    public static void main(String[] args){
        movingCount(5,10,10);
    }
}
