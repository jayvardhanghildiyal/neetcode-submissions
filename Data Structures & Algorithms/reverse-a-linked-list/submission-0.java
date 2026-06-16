/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode NEXT = new ListNode();
        ListNode prev = new ListNode();

        prev = null;

        while (head != null) {
            NEXT = head.next;
            head.next = prev;
            prev = head;
            head = NEXT;
        }

        return prev;
    }
}
