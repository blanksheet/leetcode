/**
 * Created by tianze
 * 2018/12/11 17:01
 */
public class reOrderArray {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return ;
        }
        int odd = 0;
        int[] res = new int[array.length];

        int count  = 0;

        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) == 1){
                odd++;
            }
            res[i] = array[i];
        }

        for(int i : res){
            if(i % 2 == 1){
                array[count] = i;
                count++;
            }
            else {
                array[odd] = i;
                odd++;
            }
        }

    }

}
