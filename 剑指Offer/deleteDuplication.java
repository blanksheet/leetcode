import java.util.LinkedList;

/**
 * Created by tianze
 * 2019/1/6 16:56
 */
public class deleteDuplication {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return pHead;
        }
        LinkedList<ListNode> linkedList = new LinkedList<>();
        linkedList.add(pHead);

        int value = pHead.val;
        pHead = pHead.next;

        while (pHead != null){
            if(value != pHead.val){
                linkedList.add(pHead);
                value = pHead.val;
                pHead = pHead.next;
            }
            else {
                if(linkedList.size() == 0){
                    pHead = pHead.next;
                }
                else {
                    linkedList.removeLast();
                    pHead = pHead.next;
                }
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (ListNode temp : linkedList){
            head.next = temp;

            head = head.next;
        }
        head.next = null;

        return dummy.next;
    }

    public ListNode deleteDuplication2(ListNode pHead){
        if(pHead == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode run = dummy;
        dummy.next = pHead;

        while (pHead != null){
            if(pHead.next != null && pHead.val == pHead.next.val){
                while (pHead.next != null && pHead.next.val == pHead.val){
                    pHead = pHead.next;
                }
                pHead = pHead.next;
                run.next = pHead;
            }
            else {
                pHead = pHead.next;
                run = run.next;
            }
        }

        return dummy.next;
    }
    {

    }

    public  static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        deleteDuplication(l1);
    }

}
