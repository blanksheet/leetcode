import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianze
 * 2018/11/27 20:10
 */
public class generateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] temp,int index,List<String> conbin){
        if(index == temp.length){
            if(valid(temp))
              conbin.add(new String(temp));
        }
        else {
            temp[index] = '(';
            generateAll(temp,index+1,conbin);
            temp[index] = ')';
            generateAll(temp,index+1,conbin);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return (balance == 0);
    }

    //优化算法
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args){
        List<String> result = generateParenthesis(2);

        for(int i=0; i<result.size();i++){
           System.out.println(result.get(i));
        }
    }

}
