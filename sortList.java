import java.util.List;

/**
 * Created by tianze
 * 2019/3/5 11:26
 */
public class sortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next !=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list1 = head;
        ListNode list2 = slow.next;

        slow.next = null;
        list1 = mergeSort(list1);
        list2 = mergeSort(list2);

        return merge(list1,list2);
    }

    public ListNode merge(ListNode list1, ListNode list2){

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode(0);

        if(list1.val < list2.val){
            dummy = list1;
            dummy.next = merge(list1.next, list2);

        }
        else {
            dummy = list2;
            dummy.next = merge(list1, list2.next);
        }

        return dummy;
    }
}
