import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by tianze
 * 2019/1/3 16:59
 */
public class FindNumsAppearOnce {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2){
            return;
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();


        for(int i : array){
            if(hashMap.containsKey(i)){
                hashMap.put(i,hashMap.get(i) + 1);
            }
            else {
                hashMap.put(i,0);
            }
        }
        int[] result = new int[2];
        int index = 0;
        for (int i : array){
            if(hashMap.get(i) == 0){
                result[index] = i;
                index++;
            }
        }

        num1[0] = result[0];
        num2[0] = result[1];
    }

    public static void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        if(array.length < 2){
            return ;
        }
        int myxor = 0;

        for(int i = 0 ; i < array.length; ++ i ){
            myxor ^= array[i];
        }


        for(int i = 0; i < array.length; ++ i ){
            if((myxor & array[i]) == 0){
                num2[0]^= array[i];
            }
            else{
                num1[0]^= array[i];
            }
        }
    }

    public static void main(String[] args){
        int[] array = {2,4,3,6,3,2,5,5};
        FindNumsAppearOnce2(array,new int[1],new int[1]);
    }

}
