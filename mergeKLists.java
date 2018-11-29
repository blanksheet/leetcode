import java.util.*;

/**
 * Created by tianze
 * 2018/11/28 17:16
 */
public class mergeKLists {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1){
            return lists[0];
        }

        List date = new LinkedList();

        for(int i = 0; i < lists.length; i++){
            while(lists[i] != null){
                date.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        Integer[] nums = new Integer[date.size()];
        date.toArray(nums);

        Arrays.sort(nums);

        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(0);
        dummy.next = head;

        int count =0;
        while(count < date.size()){
            ListNode temp = new ListNode(nums[count]);
            head.next = temp;
            head = head.next;
            count++;
        }

        return dummy.next.next;
    }

    //优先队列
    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy=new ListNode(-1);
        ListNode node=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        });
        for(ListNode head:lists){
            if(head!=null){
                pq.offer(head);
            }
        }
        while(pq.size()>0){
            node.next=pq.poll();
            node=node.next;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        l7.next = l8;

        ListNode[] test = new ListNode[3];
        test[0] = l1;
        test[1] = l4;
        test[2] = l7;

        System.out.println(mergeKLists2(test));
    }

}
