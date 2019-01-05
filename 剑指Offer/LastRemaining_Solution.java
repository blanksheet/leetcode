import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by tianze
 * 2019/1/5 16:10
 */
public class LastRemaining_Solution {
    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0 && m == 0){
            return -1;
        }

        LinkedList<Integer> data = new LinkedList();

        for(int i = 0; i < n; i++){
            data.add(i);
        }

        int index = -1;
        while (data.size() > 1){
            index = (index + m) % data.size();
            data.remove(index);
            index--;
        }

        return data.get(0);
    }

    public static void main(String[] args){
        LastRemaining_Solution(5,3);
    }
}
