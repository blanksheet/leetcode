/**
 * Created by tianze
 * 2018/11/15 15:04
 */
public class myAtoi {
    public static int myAtoi(String str) {
      if(str==null||str.length()==0){
          return 0;
      }
      boolean flag = true;
      int result = 0;
      int i = 0;

      while(str.charAt(i)==' '){
          i++;
          if(i==str.length()){
              return 0;
          }
      }

      if(str.charAt(i)=='+'||str.charAt(i)=='-'){
          flag = str.charAt(i)=='+' ?  true:false;
          i++;
      }

      while(i<str.length()){
          int count = str.charAt(i) - '0';
          if(count>9||count<0){
              break;
          }
          if(result>(Integer.MAX_VALUE-count)/10){
              return flag==true? Integer.MAX_VALUE:Integer.MIN_VALUE;
          }
          result = 10*result + count;
          i++;
      }
        return result*(flag?1:-1);
    }


    public static void main(String[] args){
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }

}

