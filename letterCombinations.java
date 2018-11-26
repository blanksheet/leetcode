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
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        for(char ch: digits.toCharArray()) {
            int digit = ch - '0';
            if (digit < 2 || digit > 9) {
                return res;
            }
        }
        helper(digits, res, new StringBuilder(), 0);
        return res;
    }
    private static void helper(String digits, List<String> list, StringBuilder sb, int index) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String chs = strs[digits.charAt(index) - '0'];
        for (int i = 0; i < chs.length(); i ++) {
            sb.append(chs.charAt(i));
            helper(digits, list, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args){
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
