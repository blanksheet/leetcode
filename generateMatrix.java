/**
 * Created by z84123321 on 2019/4/17.
 */
public class generateMatrix {
    public static int[][] generateMatrix(int n) {
        if(n <= 0){
            return new int[0][0];
        }
        if(n == 1){
            int[][] result = new int[0][0];
            result[0][0] = n;
            return result;
        }

        int[][] array = new int[n][n];

        int index = 1;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - i - 1; j++){
                array[i][j] = index;
                index++;
            }
            for(int j = i; j < n- i - 1;j++){
                array[j][n - i - 1] = index;
                index++;
            }
            for(int j = n - i - 1; j > i; j--){
                array[n - i - 1][j] = index;
                index++;
            }
            for(int j = n - i - 1; j > i; j--){
                array[j][i] = index;
                index++;
            }
        }

        if(n % 2 == 1){
            array[n / 2][n / 2] = index;
        }

        return array;
    }

    public static void main(String[] args){
        generateMatrix(3);
    }
}
