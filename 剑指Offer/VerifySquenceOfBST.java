import java.util.Arrays;

/**
 * Created by tianze
 * 2018/12/17 11:40
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }

        int root = sequence[sequence.length - 1];

        int left = 0;
        for ( ; left < sequence.length - 1; left++){
            if(sequence[left] > root){
                break;
            }
        }

        int right = left;
        for( ; right < sequence.length - 1; right++){
            if(root > sequence[right]){
                return false;
            }
        }

        boolean leftTrue = true;
        if(left > 0){
            leftTrue = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,left));
        }

        boolean rightTrue = true;
        if(right < sequence.length - 1){
            rightTrue = VerifySquenceOfBST(Arrays.copyOfRange(sequence,right ,sequence.length - 1));
        }
        return leftTrue && rightTrue;
    }
}
