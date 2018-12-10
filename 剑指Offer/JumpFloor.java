/**
 * Created by tianze
 * 2018/12/10 11:34
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        int first = 1;
        int second = 2;

        for(int i = 3;i < target; i++){
            int temp = first + second;
            first = second;
            second = temp;
        }

        return first + second;
    }
}
