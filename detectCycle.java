import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianze
 * 2019/3/6 10:46
 */
public class detectCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> hashSet = new HashSet();

        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        if(hasCycle){
            ListNode res = head;
            while (res != slow){
                res = res.next;
                slow = slow.next;
            }
            return res;
        }
        else {
            return null;
        }



    }
}
