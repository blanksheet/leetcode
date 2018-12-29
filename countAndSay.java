import javax.swing.plaf.synth.SynthEditorPaneUI;

/**
 * Created by tianze
 * 2018/12/29 16:15
 */
public class countAndSay {
    public static String countAndSay(int n) {
        if(n <= 0){
            return "";
        }

        String temp  = "1";

        for(int i = 2; i <= n; i++){
            StringBuffer curTemp = new StringBuffer();
            int count = 1;
            for(int j = 1; j < temp.length(); j++){
                if(temp.charAt(j) == temp.charAt(j - 1)){
                    count++;
                }
                else {
                    curTemp.append(count);
                    count = 1;
                    curTemp.append(temp.charAt(j - 1));
                }
            }
            curTemp.append(count);
            curTemp.append(temp.charAt(temp.length() - 1));
            temp = curTemp.toString();
        }

        return temp;
    }

    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }
}
