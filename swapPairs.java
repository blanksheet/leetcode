/**
 * Created by tianze
 * 2018/11/29 11:26
 */
public class swapPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode start = new ListNode(0);
        start.next = head;
        for(ListNode cur = start; cur.next!=null&&cur.next.next!=null; cur=cur.next.next){
            cur.next = swap(cur.next, cur.next.next);
        }
        return start.next;
    }
    public static ListNode swap(ListNode head1, ListNode head2){
        head1.next = head2.next;
        head2.next = head1;
        return head2;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode listNode = swapPairs(l1);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
