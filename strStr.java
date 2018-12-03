/**
 * Created by tianze
 * 2018/12/3 11:07
 */
public class strStr {
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() ==0){
            return 0;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }

        for(int i = 0; i < haystack.length() - needle.length()+1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,i+needle.length()).equals(needle)){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        String haystack = "a";
        String needle = "a";

        System.out.println(strStr(haystack,needle));
    }
}
