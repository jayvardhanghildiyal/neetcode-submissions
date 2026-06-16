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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = new ListNode();
        ListNode curr2 = new ListNode();

        ListNode next1 = new ListNode();
        ListNode next2 = new ListNode();

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        curr1 = list1;
        curr2 = list2;

        next1 = list1.next;
        next2 = list2.next;

        while (curr1 != null && curr2 != null) {
            if (curr1.val > curr2.val) {

                while (curr2.next != null && curr2.next.val <= curr1.val) {
                    curr2 = next2;
                    next2 = next2.next;
                }
                
                curr2.next = curr1;
                curr2 = next2;
                
                if (next2 != null) {
                    next2 = next2.next;
                }

            } else {

                while (curr1.next != null && curr1.next.val <= curr2.val) {
                    curr1 = next1;
                    next1 = next1.next;
                } 
                
                curr1.next = curr2;
                curr1 = next1;

                if (next1 != null) {
                    next1 = next1.next;
                }
            }
        }

        if (list1.val > list2.val) {
            return list2;
        } else {
            return list1;
        }
    }
}