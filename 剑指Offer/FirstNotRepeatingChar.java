import java.util.*;

/**
 * Created by tianze
 * 2019/1/2 15:05
 */
public class FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }

        HashMap<Character,Integer> data = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(data.containsKey(str.charAt(i))){
                data.put(str.charAt(i),Integer.MAX_VALUE);
            }
            else {
                data.put(str.charAt(i), i);
            }
        }

        Collection<Integer> value = data.values();
        Iterator<Integer> iterator = value.iterator();

        int result = Integer.MAX_VALUE;

        while (iterator.hasNext()){
            result = Math.min(result, iterator.next());
        }

        if(result == Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }


    public static void main(String[] args){
        String str = "aabbcc";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
