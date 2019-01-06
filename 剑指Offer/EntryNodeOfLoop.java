import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianze
 * 2019/1/6 16:13
 */
public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meet = theNodesOfLoop(pHead);
        if(meet == null){
            return null;
        }

        int count = 0;
        ListNode run = meet;

        while (run.next != meet){
            run = run.next;
            count++;
        }

        ListNode fast = pHead;
        while (count >= 0){
            fast = fast.next;
            count--;
        }

        while (pHead != fast){
            pHead = pHead.next;
            fast = fast.next;
        }

        return pHead;
    }

    private ListNode theNodesOfLoop(ListNode pHead){
       if(pHead == null || pHead.next == null){
           return null;
       }

       ListNode slow = pHead.next;
       ListNode fast = slow.next;

       while (slow != null && fast != null){
           if(slow == fast){
               return slow;
           }

           slow = slow.next;
           fast = fast.next;

           if(fast != null){
               fast = fast.next;
           }
       }

       return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        LinkedList<ListNode> listNodes = new LinkedList<>();

        while (pHead != null){
            if(listNodes.contains(pHead)){
                return pHead;
            }
            else {
                listNodes.add(pHead);
                pHead = pHead.next;
            }
        }

        return null;
    }
}
