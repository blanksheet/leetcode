/**
 * Created by tianze
  * 2018/9/29 20:27
 */
public class longestPalindrome {
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,(i+1));
            int result = Math.max(len1,len2);
            if(result>end-start){
                start = i-(result-1)/2;
                end = i+result/2;
            }
        }

        return s.substring(start,end+1);
    }

    public static int expand(String s, int low,int high){
        int L = low;
        int H = high;

        while(L>=0 && H<s.length() && s.charAt(L)==s.charAt(H)){
            L--;
            H++;
        }
        return H-L-1;
    }

    public static void main(String[] args){
        String s = "babad";
        int result = 0;
        result = expand(s,2,3);

        System.out.println(longestPalindrome(s));
    }
}
