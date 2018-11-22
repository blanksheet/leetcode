/**
 * Created by tianze
 * 2018/11/22 10:50
 */
public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String result = new String();

        if(strs.length==0){
            return result;
        }

        if(strs.length==1){
            return strs[0];
        }

        result = (match(strs[0],strs[1]));

        for(int i=2;i<strs.length;i++){
            result = match(result,strs[i]);
        }

        //result = "\""+result+"\"";
        return result;
    }

    public static String match(String str1,String str2){
        StringBuilder result = new StringBuilder();

        for(int i=0;i<Math.min(str1.length(),str2.length());i++){
            if(str1.charAt(i)==str2.charAt(i)){
                result.append(str1.charAt(i));
            }
            else{
                break;
            }
        }

        return result.toString();
    }

    //参考示例
    public String longestCommonPrefix2(String[] strs) {
        if(strs==null || strs.length<1)
            return "";
        String result = strs[0];
        for(int i=1; i<strs.length; i++){
            if(!strs[i].startsWith(result)){
                result = result.substring(0, result.length()-1);
                i--;
            }
        }
        return result;
    }
    public static void main(String[] args){
        String[] test1 = {"flower","flow","flight"};
        String[] test2 = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(test1));
        System.out.println(longestCommonPrefix(test2));
    }
}
