import java.util.ArrayList;

/**
 * @Author: tianze
 * @Date: 2019/1/21 10:51
 */
public class reverseWords {
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        String[] temp = s.split(" ");

        ArrayList<String> data = new ArrayList<>();

        for(String string : temp){
            if(!string.equals("")){
                data.add(string);
            }
        }

        StringBuffer result = new StringBuffer();

        for(int i = data.size() - 1; i > 0; i--){
            if(i == 0){
                result.append(data.get(i));
            }
            else {
                result.append(data.get(i) + " ");
            }
        }


        return result.toString();
    }

    public static void main(String[] args){
        String s = " 1";
        System.out.println(reverseWords(s));
    }

}
