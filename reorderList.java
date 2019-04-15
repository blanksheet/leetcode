package com;

import java.util.WeakHashMap;

/**
 * Created by tianze on 2019/4/15.
 */
public class reorderList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }

        ListNode slow = head;
        ListNode fast = head;
        while ((fast.next != null) && (fast.next.next != null)){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;

        slow.next = null;
        head2 = reverse(head2);

        while (head1 != null && head2 != null){
            ListNode next = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head2.next;
            head2 = next;
        }
    }

    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
public static ListNode recursive_reverse(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode pre = recursive_reverse(head.next);
    head.next.next = head;
    head.next = null;

    return pre;
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

        ListNode head = recursive_reverse(l1);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
