import java.util.ArrayList;

/**
 * Created by tianze
 * 2018/12/14 16:42
 */
public class printMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        if(matrix == null ||matrix.length == 0){
            return result;
        }

        int start = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        while (row > start*2 && col > start*2){
            result = addMatrixInCircle(result,matrix,start);
            start++;
        }

        return result;
    }

    private static ArrayList<Integer> addMatrixInCircle(ArrayList result, int[][] matrix, int start){
        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 -start;

        for(int i = start ; i <= endX; i++){
            result.add(matrix[start][i]);
        }

        if(start < endY){
            for(int i = start + 1 ; i <= endY ; i++){
                result.add(matrix[i][endX]);
            }
        }

        if(start<endY && start < endX){
            for(int i = endX - 1 ; i >= start; i--){
                result.add(matrix[endY][i]);
            }
        }

        if(start < endX && start < endY - 1){
            for(int i = endY - 1; i >= start + 1; i--){
                result.add(matrix[i][start]);
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] array = {{1},{2},{3},{4},{5}};
        printMatrix(array);
    }
}
