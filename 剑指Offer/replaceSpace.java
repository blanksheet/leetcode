/**
 * Created by tianze
 * 2018/12/5 16:33
 */
public class replaceSpace {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length()==0){
            return "";
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i<str.length();i++){
            if(str.charAt(i) == ' '){
                result.append("%20");
            }
            else {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }
}
