/**
 * Created by tianze
 * 2019/1/4 17:11
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        String result = new String();
        if(str == null || str.length() == 0 || n > str.length()){
            return result;
        }

        result  = str.substring(n) + str.substring(0,n);
        return result;
    }
}
