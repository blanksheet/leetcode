/**
 * @Author: tianze
 * @Date: 2019/3/4 21:41
 */
public class isMatch2 {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length() == 0;
        }

        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;

        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) != '*'){
                for(int i = s.length() - 1; i >= 0; i --){
                    result[i + 1] = result[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
                }
            }
            else {
                int i = 0;
                while (i <= s.length() && !result[i]){
                    i++;
                }
                for( ; i <=s.length(); i++){
                    result[i] = true;
                }
            }

            result[0] = result[0] && p.charAt(j) == '*';
        }

        return result[s.length()];
    }
}
