/**
 * Created by tianze
 * 2019/1/6 14:18
 */
public class match {
    public boolean match(char[] str, char[] pattern)
    {
        return helper(str, pattern, 0, 0);
    }

    private boolean helper(char[] str, char[] pattern, int startIndex, int endIndex){
        if(endIndex == pattern.length){
            return startIndex == str.length;
        }

        if(endIndex == pattern.length - 1 || pattern[endIndex + 1] != '*'){
            if(startIndex < str.length && (str[startIndex] == pattern[endIndex] || pattern[endIndex] == '.')){
                return helper(str, pattern, startIndex + 1, endIndex + 1);
            }
            else {
                return false;
            }
        }
        else {
            while (startIndex < str.length && (str[startIndex] == pattern[endIndex] || pattern[endIndex] == '.')){
                if(helper(str, pattern, startIndex, endIndex + 2)){
                    return true;
                }
                else {
                    startIndex++;
                }
            }
        }

        return helper(str, pattern, startIndex, endIndex + 2);
    }
}
