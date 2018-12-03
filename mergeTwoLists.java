import java.util.List;

/**
 * Created by tianze
 * 2018/12/3 10:12
 */
public class mergeTwoLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(0);
        dummy.next = head;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
                head = head.next;
            }
            else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
                head = head.next;
            }
        }

        if(l1 == null && l2 == null){
            return dummy.next.next;
        }

        if(l1 == null){
            head.next = l2;
        }

        if(l2 == null){
            head.next = l1;
        }

        return dummy.next.next;
    }

    //一个很好的参考思路
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);


        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;


        System.out.println(mergeTwoLists(l1,l4));
    }
}
