/**
 * Created by tianze
 * 2018/12/5 16:23
 */
public class Find {
    public static boolean Find(int [][] array,int target) {
        int row = array.length;
        int col = array[0].length;

        if (row == 0 && col == 0){
            return false;
        }

        int findRow = 0;
        int findCol = col-1;

        while(findRow < row && findCol >= 0){
            if(array[findRow][findCol] == target){
                return true;
            }
            else if(array[findRow][findCol] > target){
                findCol--;
            }
            else {
                findRow++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = {
                {1,2},
                {2,3}
        };
        System.out.println(Find(array,2));
    }
}
