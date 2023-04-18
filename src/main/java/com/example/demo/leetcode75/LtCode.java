package com.example.demo.leetcode75;

/**
 * @author zhp
 * @date 2023/4/18 15:53
 **/
public class LtCode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //876. 链表的中间结点 快慢双指针，快指针每次走两步，慢指针每次走一步
    public ListNode middleNode(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
