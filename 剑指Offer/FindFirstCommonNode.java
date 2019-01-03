import javax.swing.*;
import java.util.HashMap;

/**
 * Created by tianze
 * 2019/1/3 11:01
 */
public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }

        HashMap<ListNode,ListNode> hashMap = new HashMap();
        while (pHead1 != null){
            hashMap.put(pHead1, null);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            if(hashMap.containsKey(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }

        return null;
    }
}
