import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tianze
 * 2018/12/5 17:19
 */
public class findSubstring {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return result;
        }

        HashMap<String,Integer> dic = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            if(dic.containsKey(words[i])){
                dic.put(words[i],dic.get(words[i])+1);
            }
            else{
                dic.put(words[i],1);
            }
        }

        int wordLen = words[0].length();

        for(int i = 0; i < wordLen; i++){
            HashMap<String,Integer> cur = new HashMap<>();
            int left = i;
            int count = 0;
            for(int j = i; j <= s.length()-wordLen; j += wordLen){
                String temp = s.substring(j,j+wordLen);

                if(dic.containsKey(temp)){
                    if(cur.containsKey(temp)){
                        cur.put(temp,cur.get(temp)+1);
                    }
                    else{
                        cur.put(temp,1);
                    }

                    if(cur.get(temp) <= dic.get(temp)){
                        count++;
                    }
                    else{
                        while(cur.get(temp) > dic.get(temp)){
                            String del1 = s.substring(left,left+wordLen);
                            if(cur.containsKey(del1)){
                                cur.put(del1,cur.get(del1)-1);
                                if(cur.get(del1) < dic.get(del1)){
                                    count--;
                                }
                            }

                            left = left + wordLen;
                        }
                    }

                    if(count == words.length){
                        result.add(left);
                        String del2 = s.substring(left,left+wordLen);
                        if(cur.containsKey(del2)){
                            cur.put(del2,cur.get(del2)-1);
                        }
                        count--;
                        left = left +wordLen;
                    }
                }
                else{
                    cur.clear();
                    left = j +wordLen;
                    count = 0;
                }

            }
        }
        return result;
    }

    public static void main(String[] args){
        String s = "barfoofoobarthefoobarman";
        String[] words = {
                "bar","foo","the"
        };

        System.out.println(findSubstring(s,words));
     }
}
