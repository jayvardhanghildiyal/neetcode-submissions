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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode one = new ListNode();

        one = head;
        int len = 0;

        while (one != null) {
            len += 1;
            one = one.next;
        }   


        int position = len - n + 1;

        int hit = 0;

        one = head;

        while (one != null) {
            hit += 1;

            if (position - 1 == 0) {
                one = one.next;
                return one;
            } else if (hit == position - 1) {
                one.next = one.next.next;
                break;
            } else {
                one = one.next;
            }
        }

        return head;

    }
}
