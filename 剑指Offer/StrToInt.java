/**
 * Created by tianze
 * 2019/1/5 16:43
 */
public class StrToInt {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }

        int result = 0;
        int count = 0;

        int flag = 1;

        if(str.charAt(0) == '+'){
            flag = 1;
            str = str.substring(1);
        }

        if(str.charAt(0) == '-'){
            flag = -1;
            str = str.substring(1);
        }

        if(str.length() == 0){
            return 0;
        }
        
        for(int i = str.length() - 1; i >= 0; i--){
            count = count * 10;
            if(str.charAt(i) > '0' && str.charAt(i) < '9'){

                if(count == 0){
                    result += (str.charAt(i) - '0');
                    count = 1;
                }
                else {
                    result += (str.charAt(i) - '0') * count;
                }

                if(result > Integer.MAX_VALUE){
                    return 0;
                }
            }
            else {
                return 0;
            }
        }

        return flag * result;
    }
}
