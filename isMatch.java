/**
 * Created by tianze
 * 2018/12/4 15:17
 */
public class isMatch {
    public static boolean isMatch(String s, String p) {
        return slove(s.toCharArray(),p.toCharArray(),0,0);
    }

    public static boolean slove(char[] s,char[] p,int sIndex,int pIndex){
        if(pIndex == p.length){
            return sIndex == s.length;
        }

        if(pIndex == p.length-1 || p[pIndex+1] != '*'){
            if(sIndex < s.length && (p[pIndex] == s[sIndex] || p[pIndex] == '.')){
                return slove(s,p,sIndex+1,pIndex+1);
            }
            else {
                return false;
            }
        }
        else{
            while(sIndex < s.length && (p[pIndex] == s[sIndex] || p[pIndex] == '.')){
                if(slove(s,p,sIndex,pIndex+2)){
                    return true;
                }
                else {
                    sIndex++;
                }
            }
        }

        return slove(s,p,sIndex,pIndex+2);
    }

    public static void main(String[] args){
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s,p));
    }

}
