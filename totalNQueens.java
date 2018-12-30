import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianze
 * 2018/12/30 16:25
 */
public class totalNQueens {
    public static int totalNQueens(int n) {
        int result[] = new int[1];
        if(n <= 0){
            return result[0];
        }
        helper(n, 0, new int[n],result);
        return result[0];
    }

    private static void helper(int n, int row, int[] columnForRow, int[] count){
        if(n == row){
            List<String> item = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuffer stringRow = new StringBuffer();
                for(int j = 0; j < n; j++){
                    if(columnForRow[i] == j){
                        stringRow.append('Q');
                    }
                    else {
                        stringRow.append('.');
                    }
                }
                item.add(stringRow.toString());
            }
            count[0] += 1;
            return;
        }

        for(int i = 0; i < n; i++){
            columnForRow[row] = i;
            if(check(row, columnForRow)){
                helper(n, row + 1, columnForRow,count);
            }
        }

    }

    private static boolean check(int row, int[] columnForRow){
        for(int i = 0; i< row; i++){
            if(columnForRow[i] == columnForRow[row] || Math.abs(columnForRow[i] - columnForRow[row]) == (row - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
       int result = totalNQueens(4);
       System.out.println(result);


    }
}
