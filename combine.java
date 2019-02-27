import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianze
 * 2019/2/27 15:41
 */
public class combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if(n <= 0 || n < k){
            return result;
        }

        helper(n, k,1, new ArrayList<Integer>(), result);
        return result;
    }

    private static void helper(int n, int k, int start, List<Integer> item, List<List<Integer>> result){
        if(item.size() == k){
            result.add(new ArrayList<>(item));
            return;
        }

        for(int i = start; i <= n; i++){
            item.add(i);
            helper(n, k, i + 1, item, result);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args){
        combine(4,2);
    }
}
