/**
 * Created by tianze
 * 2018/12/14 15:34
 */
public class Merge {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //Recursive function
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode(0);

        if(list1.val < list2.val){
            dummy = list1;
            dummy.next = Merge(list1.next, list2);
        }
        else {
            dummy = list2;
            dummy.next = Merge(list1,list2.next);
        }

        return dummy;
    }

    //Traverse function
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(list1 !=null && list2 !=null){
            if(list1.val < list2.val){
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
            }
            else {
                dummy.next = list2;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }

        if(list1 == null){
            dummy.next = list2;
        }
        if(list2 == null){
            dummy.next = list1;
        }

        return head.next;
    }
}
