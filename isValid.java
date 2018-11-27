import java.util.HashMap;
import java.util.Stack;

/**
 * Created by tianze
 * 2018/11/27 19:03
 */
public class isValid {
    public static boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }

        if(s.length()%2!=0){
            return false;
        }

        Stack<Character> save = new Stack<>();
        save.push(s.charAt(0));
        char temp;

        for(int i = 1; i < s.length(); i++){

            if(save.empty()){
                save.push(s.charAt(i));
                continue;
            }
            else{
                temp = save.pop();
            }
            switch (s.charAt(i)){
                case '}':
                    if(temp == '{')
                      break;
                    else {
                       return false;
                    }
                case ']':
                    if(temp == '[')
                      break;
                    else{
                        return false;
                    }
                case ')':
                    if(temp == '(')
                      break;
                    else{
                        return false;
                    }
                default:
                    save.push(temp);
                    save.push(s.charAt(i));
            }

        }

        return save.empty();
    }



    public static void main(String[] args){
        String ex1 = "(]";
        System.out.println(isValid(ex1));
    }
}
