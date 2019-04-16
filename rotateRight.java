import com.reorderList;

/**
 * Created by tianze on 2019/4/16.
 */
public class rotateRight {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int length = 1;

        ListNode count = head;
        while (count.next != null){
            length++;
            count = count.next;
        }

        int rightK = k % length;
        if(rightK == 0){
            return head;
        }


        ListNode cur = head;

        int run = 1;
        while (run != length - rightK){
            cur = cur.next;
            run++;
        }
        ListNode add = cur.next;

        cur.next = null;

        ListNode res = add;
        while (add.next != null){
            add = add.next;
        }
        add.next = head;
        return res;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode walker = head;
        ListNode runner = head;
        int step = 0;

        while (runner != null && step < k){
            runner = runner.next;
            step++;
        }

        if(runner == null){
            k = k % step;
            step = 0;
            runner = head;
            while (runner.next != null && step < k){
                runner = runner.next;
                step++;
            }
        }

        while (runner.next != null){
            walker = walker.next;
            runner = runner.next;
        }

        runner.next = head;
        ListNode rotate = walker.next;
        walker.next = null;
        return rotate;
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

        ListNode head = rotateRight2(l1,7);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
