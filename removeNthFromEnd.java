/**
 * Created by tianze
 * 2018/11/27 15:52
 */
public class removeNthFromEnd {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        int length = 0;
        ListNode temp = head;
        ListNode result = head;

        while (head!=null){
            length++;
            head = head.next;
        }

        int count = 0;

        if(n == length){
           return result.next;
        }

        while (temp!=null){
            count++;

            if(count == length -n){
                temp.next= temp.next.next;
                continue;
            }

            temp = temp.next;
        }

        return result;
    }

    //参考题解
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

       ListNode print = removeNthFromEnd(l1,2);

        while (print!=null){
            System.out.println(print.val);
            print = print.next;
        }
    }

}
