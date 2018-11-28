import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianze
 * 2018/11/23 14:55
 */
public class letterCombinations {
    static String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        calculate(digits,result,new StringBuilder(),0);
        return result;
    }

    private static void calculate(String digits, List<String> result,StringBuilder put, int index){
        if(index == digits.length()){
            result.add(put.toString());
            return;
        }

        for(int i = 0;i < strs[digits.charAt(index) - '0'].length();i++){
            put.append(strs[digits.charAt(index) - '0'].charAt(i));
            calculate(digits,result,put,index+1);
            put.deleteCharAt(put.length()-1);
        }
    }

    public static void main(String[] args){
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
