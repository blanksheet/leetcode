import java.util.HashMap;

/**
 * @Author: tianze
 * @Date: 2019/1/5 22:53
 */
public class duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0){
            duplication[0] = -1;
            return false;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i : numbers){
            if(hashMap.containsKey(i)){
                duplication[0] = i;
                return true;
            }
            else {
                hashMap.put(i,i);
            }
        }
        return false;
    }
}
