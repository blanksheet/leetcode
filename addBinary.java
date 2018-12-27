/**
 * @Author: tianze
 * @Date: 2018/12/27 21:29
 */
public class addBinary {
    public static String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        StringBuffer result = new StringBuffer();

        int indexA = arrayA.length - 1;
        int indexB = arrayB.length - 1;
        int sum = 0;

        while(indexA >= 0 || indexB >= 0 || sum > 0){
            if(indexA >= 0){
                sum += arrayA[indexA] - '0';
                indexA--;
            }
            if(indexB >= 0){
                sum += arrayB[indexB] - '0';
                indexB--;
            }

            int temp = sum % 2;
            sum = sum/2;
            result.append(temp);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }
}
