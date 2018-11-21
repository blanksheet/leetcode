/**
 * Created by tianze
 * 2018/11/21 16:30
 */
public class intToRoman {
    public static String intToRoman(int num) {
        StringBuffer result = new StringBuffer();


        if(num/1000>=1) {
            int num1 = num/1000;
            for(int i=0;i<num1;i++){
                result.append("M");
            }
            num = num % 1000;
        }
        if(num/100>=1){
            if(num/100==9){
                result.append("CM");
            }
            if(num/100>=5 && num/100!=9){
                result.append("D");
                int num2 = num/100-5;
                for(int i=0;i<num2;i++){
                    result.append("C");
                }
            }
            if(num/100==4){
                result.append("CD");
            }
            if(num/100<4){
                int num3 = num/100;
                for(int i=0;i<num3;i++){
                    result.append("C");
                }
            }
            num = num%100;
        }
        if(num/10>=1){
            if(num/10==9){
                result.append("XC");
            }
            if(num/10>=5 && num/10!=9){
                result.append("L");
                int num2 = num/10-5;
                for(int i=0;i<num2;i++){
                    result.append("X");
                }
            }
            if(num/10==4){
                result.append("XL");
            }
            if(num/10<4){
                int num3 = num/10;
                for(int i=0;i<num3;i++){
                    result.append("X");
                }
            }
            num = num%10;
        }
        if(num>=1){
            if(num==9){
                result.append("IX");
            }
            if(num>=5 && num!=9){
                result.append("V");
                int num2 = num-5;
                for(int i=0;i<num2;i++){
                    result.append("I");
                }
            }
            if(num==4){
                result.append("IV");
            }
            if(num<4){
                int num3 = num;
                for(int i=0;i<num3;i++){
                    result.append("I");
                }
            }
        }

        return result.toString();
    }

    //参考答案
    public String intToRoman2(int num) {
        String[][] map={
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        StringBuilder roman = new StringBuilder();
        roman.append(map[3][num/1000%10]);
        roman.append(map[2][num/100%10]);
        roman.append(map[1][num/10%10]);
        roman.append(map[0][num%10]);
        return roman.toString();
    }

    public static void main(String[] args){
        int num = 58;
        System.out.println(intToRoman(num));
    }
}
