/**
 * Created by tianze
 * 2019/1/4 16:59
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        String result = new String();
        if(str ==null || str.length() == 0){
            return result;
        }

        if(str.trim().equals("")){
            return str;
        }

        String[] strings = str.split(" ");

        for(int i = strings.length - 1; i >= 0; i--){
            if(i == 0){
                result += strings[i];
            }
            else {
                result += strings[i] + " ";
            }

        }

        return result;
    }
}
