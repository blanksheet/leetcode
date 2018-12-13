/**
 * Created by tianze
 * 2018/12/12 18:56
 */
public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k ==0){
            return null;
        }

        ListNode first = head;
        ListNode second  = head;

        int count = 1;

        while (count < k){
            count++;
            first = first.next;
            if(first == null){
                return null;
            }
        }

        while (first.next != null){
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        System.out.println(FindKthToTail(l1,0).val);
        System.out.println(FindKthToTail(l1,2).val);
    }


}
