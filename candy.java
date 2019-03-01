/**
 * Created by tianze
 * 2019/3/1 14:10
 */
public class candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int[] rightCount = new int[ratings.length];
        rightCount[0] = 1;

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                rightCount[i] = rightCount[i - 1] + 1;
            }
            else {
                rightCount[i] = 1;
            }
        }

        int result = rightCount[ratings.length - 1];

        for(int i = ratings.length - 2 ; i >= 0; i--){
            int cur = 1;
            if(ratings[i] > ratings[i + 1]){
                cur = rightCount[i + 1] + 1;
            }
            result += Math.max(cur,rightCount[i]);

            rightCount[i] = cur;
        }

        return result;
    }
}
