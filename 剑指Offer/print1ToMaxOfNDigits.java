/**
 * Created by tianze
 * 2018/12/12 19:24
 */
public class print1ToMaxOfNDigits {
    public static void print1ToMaxOfNDigits(int n){
        if(n <= 0){
            return;
        }

        char[] nums = new char[n];

        for(int i = 0; i < 10; i++){
            nums[0] = (char) (i + '0');
            reverse(nums,n,1);
        }

    }

    private static void reverse(char[] nums, int length, int index){
        if(index == length){
            printNums(nums);
            return;
        }

        for(int i = 0; i < 10; i++){
            nums[index] = (char) (i + '0');
            reverse(nums,length,index+1);
        }

    }

    private static void printNums(char[] nums){
        StringBuilder print = new StringBuilder();
        boolean flag = true;

        for(int i = 0 ; i < nums.length; i++){
           if(flag && nums[i] != '0'){
               flag = false;
           }

           if(!flag){
               print.append(nums[i]);
           }

        }
        System.out.println(print);
    }

    public static void main(String[] args){
        print1ToMaxOfNDigits(3);
    }

}
