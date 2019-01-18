import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianze
 * 2019/1/16 15:50
 */
public class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        //横向检查
        for(int i = 0; i < 9 ; i++){
            Set check = new HashSet();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(check.contains(board[i][j])){
                        return false;
                    }
                    else {
                        check.add(board[i][j]);
                    }
                }
            }
        }

        //竖向检查
        for(int i = 0; i < 9 ; i++){
            Set check = new HashSet();
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    if(check.contains(board[j][i])){
                        return false;
                    }
                    else {
                        check.add(board[j][i]);
                    }
                }
            }
        }

        //块检查
        for(int block = 0; block < 9; block++){
            Set check = new HashSet();
            for(int i = block / 3 * 3; i < block / 3 * 3 + 3; i++){
                for(int j = block % 3 * 3; j < block % 3 * 3 + 3; j++){
                    if(board[i][j] != '.'){
                        if(check.contains(board[i][j])){
                            return false;
                        }
                        else {
                            check.add(board[i][j]);
                        }
                    }
                }
            }
        }



        return true;
    }
}
