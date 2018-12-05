import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tianze
 * 2018/12/5 16:39
 */
public class printListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> data = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(listNode == null){
            return result;
        }

        while (listNode != null){
            data.push(listNode.val);
            listNode = listNode.next;
        }

        int count = 0;
        while (!data.empty()){
            result.add(count,data.pop());
            count++;
        }
        return result;
    }
}
