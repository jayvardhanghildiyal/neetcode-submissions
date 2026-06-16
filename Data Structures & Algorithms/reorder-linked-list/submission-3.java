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
    public void reorderList(ListNode head) {
        ListNode one = new ListNode();
        ListNode two = new ListNode();

        ListNode curr1 = new ListNode();
        ListNode curr2 = new ListNode();
        ListNode next1 = new ListNode();

        curr1 = head;
        next1 = curr1.next;

        // tail pointer

        curr2 = head;

        while (curr2.next != null) {
            curr2 = curr2.next;
        }


        while (curr1 != curr2) {
            
            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            next1 = curr1.next;


            // code for re-adjusting the curr2 tail pointer to the appropriate tail
            one = curr2;
            two = curr2;

            while (one.next != two) {
                one = one.next;
                
            }

            curr2 = one;

        }

        curr1.next = null;
        curr2.next = null;
    }
}
