import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tianze
 * 2018/12/18 20:23
 */
public class Permutation {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() == 0){
            return result;
        }

        result = permutation(result,str.toCharArray(),0);
        Collections.sort(result);
        
        return result;
    }

    private static ArrayList<String> permutation(ArrayList<String> temp,char[] str, int index){
        if(index == str.length){
           if(!temp.contains(String.valueOf(str))){
               temp.add(String.valueOf(str));
           }
        }

        for(int i  = index; i < str.length; i++){
            char tempChar = str[i];
            str[i] = str[index];
            str[index] = tempChar;

            permutation(temp,str,index+1);

            tempChar = str[i];
            str[i] = str[index];
            str[index] = tempChar;

        }

        return temp;
    }

    public static void main(String[] args){
        System.out.println(Permutation("a"));
    }

}
