import java.util.Arrays;

/**
 * Created by tianze
 * 2019/1/4 17:28
 */
public class isContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5){
            return false;
        }
        Arrays.sort(numbers);

        int zeroCount = 0;
        for(int i : numbers){
            if(i == 0){
                zeroCount++;
            }
        }

        for(int i = zeroCount; i < 4; i++){
            if(numbers[zeroCount] == numbers[zeroCount + 1]){
                return false;
            }

        }
        if(zeroCount == 4){
            return true;
        }
        else{
            if((numbers[4] - numbers[zeroCount]) <= 4){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
