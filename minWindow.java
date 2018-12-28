import java.util.HashMap;

/**
 * Created by tianze
 * 2018/12/28 12:52
 */
public class minWindow {
    public static String minWindow(String s, String t) {
        if(s == null || s.length() == 0){
            return "";
        }

        HashMap<Character,Integer> data = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            if(data.containsKey(t.charAt(i))){
                data.put(t.charAt(i), data.get(t.charAt(i)) + 1);
            }
            else {
                data.put(t.charAt(i), 1);
            }
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int minLength = s.length() + 1;
        int minStart = 0;

        for(; right < s.length(); right++){
            if(data.containsKey(s.charAt(right))){
                data.put(s.charAt(right), data.get(s.charAt(right)) - 1);
                if(data.get(s.charAt(right)) >= 0){
                    count++;
                }
                while(count == t.length()){
                    if(right - left + 1 < minLength){
                        minLength = right - left + 1;
                        minStart = left;
                    }
                    if(data.containsKey(s.charAt(left))){
                        data.put(s.charAt(left), data.get(s.charAt(left)) + 1);
                        if(data.get(s.charAt(left)) > 0){
                            count--;
                        }
                    }
                    left++;
                }
            }
        }

        if(minLength > s.length()){
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args){
        String s ="ADOBECODEBANC" ;
        String t ="ABC" ;
        System.out.println(minWindow(s,t));
    }
}
