/**
 * Created by tianze
 * 2019/1/6 13:29
 */
public class multiply {
    public int[] multiply(int[] A) {
        if(A.length == 0){
            return A;
        }

        int[] B = new int[A.length];

        B[0] = 1;

        for(int i = 1; i < A.length; i++){
            B[i] = A[i - 1] * B[i - 1];
        }

        int[] right = new int[A.length];
        right[A.length - 1] = 1;
        for(int i = A.length - 2; i >= 0; i--){
            right[i] = right[i + 1] * A[i + 1];
        }

        for(int i = 0; i < A.length; i++){
            B[i] = B[i] * right[i];
        }

        return B;
    }
}
