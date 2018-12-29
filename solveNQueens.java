import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianze
 * 2018/12/29 20:44
 */
public class solveNQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        helper(n, 0, new int[n], result);
        return result;
    }

    private static void helper(int n, int row, int[] columnForRow, List<List<String>> result){
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
            result.add(item);
            return;
        }

        for(int i = 0; i < n; i++){
            columnForRow[row] = i;
            if(check(row, columnForRow)){
                helper(n, row + 1, columnForRow,result);
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
        List<List<String>> result = solveNQueens(4);

        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.println(result.get(i).get(j));
            }
        }
    }
}
