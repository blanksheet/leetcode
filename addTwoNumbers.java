/**
 * Created by tianze
 * 2018/9/26 16:54
 */
public class addTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum =0;
        ListNode result = new ListNode(0);
        ListNode head = result;


        while (l1!=null||l2!=null||sum!=0){
            if(l1!=null){
                sum +=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum +=l2.val;
                l2 = l2.next;
            }

            head.next = new ListNode(sum%10);
            head = head.next;
            sum = sum/10;
        }
        return result.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;


        ListNode result = addTwoNumbers(l1,l4);

        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }


}




