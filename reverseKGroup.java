import java.util.List;

/**
 * Created by tianze
 * 2018/12/5 10:18
 */
public class reverseKGroup {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    //how to reverse a node
    public static ListNode reverseNode(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head.next;
        ListNode last = head;
        while(cur != null){
           last.next = cur.next;
           cur.next = pre.next;
           pre.next = cur;
           cur = last.next;
        }
        return head = dummy.next;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        if(head == null || k == 1){
            return head;
        }

        int count = 0;

        while(head != null){
            count++;
            if(count % k == 0){
                pre = reverse(pre, head.next);
                head = pre.next;
            }
            else {
                head = head.next;
            }

        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        reverseNode(l1);
    }



}
