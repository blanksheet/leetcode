/**
 * Created by tianze
 * 2018/12/11 11:22
 */
public class searchMatrix {
    //leetcode function base on the matrix properties
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int findRow = 0;
        int findCol = col-1;

        while(findRow < row && findCol >= 0){
            if(matrix[findRow][findCol] == target){
                return true;
            }
            else if(matrix[findRow][findCol] > target){
                findCol--;
            }
            else {
                findRow++;
            }
        }
        return false;
    }

    //twice binarySearch
    public static boolean searchMatrix2(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right){
            int mid = left + (right-left)/2;
            if(matrix[mid][0] == target){
                return true;
            }
            else if (matrix[mid][0] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        if(right < 0){ // this is mean the matrix has only one row and the first index is less than target
            return false;
        }

        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        while (leftCol <= rightCol){
            int mid  = leftCol + (rightCol - leftCol) / 2;
            if(matrix[right][mid] == target){
                return true;
            }
            else if(matrix[right][mid] > target){
                rightCol = mid - 1;
            }
            else {
                leftCol = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,   3,  5,  7},


        };
        searchMatrix2(matrix,3);
    }
}
