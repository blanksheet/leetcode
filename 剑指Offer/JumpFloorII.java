/**
 * Created by tianze
 * 2018/12/10 11:55
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}
