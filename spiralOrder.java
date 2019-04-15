import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianze on 2019/4/15.
 */
public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        int row = matrix[0].length;
        int col = matrix.length;

        int min = Math.min(row, col);
        int level = min / 2;

        for(int circle = 0; circle < level; circle++){
            for(int i = circle; i < row - circle - 1; i++){
                result.add(matrix[circle][i]);
            }

            for(int i = circle; i < col - circle - 1; i++){
                result.add(matrix[i][row - circle - 1]);
            }

            for(int i = row - circle - 1; i > circle; i--){
                result.add(matrix[col - circle - 1][i]);
            }

            for(int i = col - circle - 1; i > circle; i--){
                result.add(matrix[i][circle]);
            }
        }

        if(min % 2 == 1) {
            if(row > col){
                for(int i = level; i < row - level; i++){
                    result.add(matrix[level][i]);
                }
            }
            else {
                for(int i = level; i < col - level; i++){
                    result.add(matrix[i][level]);
                }
            }
        }

        return result;
    }
}
