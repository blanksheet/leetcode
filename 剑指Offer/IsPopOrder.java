import java.util.Stack;

/**
 * Created by tianze
 * 2018/12/15 10:20
 */
public class IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || popA.length == 0|| pushA.length == 0){
            return false;
        }

        if(popA.length != pushA.length){
            return false;
        }

        Stack<Integer> data = new Stack<>();

        int indexPop = 0;

        for(int i = 0; i < pushA.length; i++){
            data.push(pushA[i]);

            while (!data.empty() && popA[indexPop] == data.peek()){
                data.pop();
                indexPop++;
            }

        }

        return data.empty();
    }

    public static void main(String[] args){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        int[] popA2 = {4,3,5,1,2};

        System.out.println(IsPopOrder(pushA,popA));
        System.out.println(IsPopOrder(pushA,popA2));
    }
}
