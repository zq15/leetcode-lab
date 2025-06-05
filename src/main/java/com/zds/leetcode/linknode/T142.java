package com.zds.leetcode.linknode;

public class T142 {
    public static ListNode detectCycle(ListNode head) {
        // 1. 先找到快慢指针相遇点
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }

        // 2. 然后重置慢指针，再次相遇的时候即为环的起点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;

        System.out.println(detectCycle(node).val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
