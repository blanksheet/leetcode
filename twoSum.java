import java.util.HashMap;

public class twoSume {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        int[] result = {0,0};

        for(int i=0;i<numbers.length;i++){
            int gap = target - numbers[i];

            if(hashMap.containsKey(gap)){
                result[1] = i+1;
                result[0] = hashMap.get(gap)+1;
                return result;
            }

            hashMap.put(numbers[i],i);
        }

        return result;
    }
}
