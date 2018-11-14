import java.util.ArrayList;


/**
 * Created by tianze
 * 2018/11/13 20:41
 */
public class convert {
    public static String  convert(String s,int numRows){
        if(numRows == 1){
            return s;
        }

        int curRows =0;
        boolean down = false;
        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();

        if(numRows>=s.length()){
            return s;
        }
        else{
            for(int i=0;i<numRows;i++){
                result.add(new StringBuilder());
            }

            for(int i =0;i<s.length();i++){
                result.get(curRows).append(s.charAt(i));
                if(curRows ==0 || curRows == numRows-1){
                    down = !down;
                }
                curRows = curRows +(down?1:-1);
            }

            StringBuilder convertString = new StringBuilder();

            for(StringBuilder sb : result){
                convertString.append(sb);
            }
            return convertString.toString();
        }

    }

    public static void main(String[] args){
        String s1 = "PAYPALISHIRING";
        String s2 = "PAYPALISHIRING";

        System.out.println(convert(s1,3));
        System.out.println(convert(s2,4));
    }
}
