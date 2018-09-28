import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {   //遍历实现 时间复杂度n3

        int ans=0;

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(isUnique(s,i,j)){
                    ans = Math.max(ans,j-i);
                }
            }
        }
        return  ans;

    }

    public  static boolean isUnique(String s,int start,int end){
        Set<Character> set = new HashSet();

        for(int i=start;i<end;i++){
            if(set.contains(s.charAt(i))){
                return false;
            }
            else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }

    public  static int lengthOfLongestSubstring2(String s){  //滑动窗口 最差时间复杂度2n 如string为bbbbb，则每个字符需要访问两次
        int ans =0;

        Set<Character> set = new HashSet<>();

        int i=0,j=0;

        while(i<s.length()&&j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) { //优化滑动窗口
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {   //j相当于头指针
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);//如发生重复 起始更新 选择i时说明二次发生重复并发生点在第一次之前 选择map.get(s.charAt(j))说明第一次发生重复
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);  //i相当于尾指针
        }
        return ans;
    }

    public static void main(String[] args){
        String string1 = "abcabcbb";
        String string2 = "bbbbb";
        String string3 = "pwwkew";
        String string4="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";

        System.out.println(lengthOfLongestSubstring(string1));
        System.out.println(lengthOfLongestSubstring(string2));
        System.out.println(lengthOfLongestSubstring(string3));

        System.out.println(lengthOfLongestSubstring2(string1));
        System.out.println(lengthOfLongestSubstring2(string2));
        System.out.println(lengthOfLongestSubstring2(string3));

        System.out.println(lengthOfLongestSubstring3(string1));
        System.out.println(lengthOfLongestSubstring3(string2));
        System.out.println(lengthOfLongestSubstring3(string3));
        System.out.println(lengthOfLongestSubstring3(string4));
    }
}
