/**
 * Created by tianze
 * 2019/2/16 14:54
 */
public class insertionSortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            pre = dummy;

            while (pre.next != null && pre.next.val <= cur.val){
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        return dummy.next;
    }
}
