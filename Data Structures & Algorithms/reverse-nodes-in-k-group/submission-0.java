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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = curr;
        ListNode dummy = new ListNode(0, null);
        ListNode dumP = dummy;


        // lets start by calculating the length of the linked list
        int len = 0;

        while (curr != null) {
            len += 1;
            curr = curr.next;
        }

        curr = head;

        // if the linked list's length is divisible by k, then we can proceed as usual

        if (len % k == 0) {
            int temp = k;
            while (curr != null) {
                nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
                temp -= 1;

                if (temp == 0) {
                    dumP.next = prev;
                    dumP = head;
                    head = curr;
                    temp = k;
                    prev = null;
                }
            }
            // if we do not have a perfect number of cycles, work the cycles we can, then attach the rest at the end
        } else {
            int cycle = len / k;
            int temp = k;
            while (cycle != 0) {
                nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
                temp -= 1;

                if (temp == 0) {
                    dumP.next = prev;
                    dumP = head;
                    head = curr;
                    temp = k;
                    prev = null;
                    cycle -= 1;
                }
            }

            dumP.next = head;
        }


        return dummy.next;
    }


    // public ListNode reverseKGroup(ListNode head, int k) {
    //     ListNode dummy = new ListNode(0, null);
    //     ListNode curr1 = head;
    //     ListNode curr2 = dummy;
    //     ListNode headge = head;

    //     int len = 0;
    //     int temp = 2;

    //     while (curr1 != null) {
    //         len += 1;
    //         curr1 = curr1.next;
    //     }
        
    //     curr1 = head;

    //     while (curr1 != null) {
    //         temp -= 1;
    //         curr1 = curr1.next;
            
    //         if (temp == 0) {
    //             temp = 2;
    //             curr1 = curr1.next;

    //         }
    //         // if (temp == 3) {
    //         //     curr2.next = reverseOneGroup(headge);
    //         //     curr2 = headge;
    //         //     headge = curr1;
    //         //     temp = 0;
    //         // } else {
    //         //     temp += 1;
    //         //     curr1 = curr1.next;
    //         // }
    //     }

    //     if (temp == 3) {
    //         curr2.next = reverseOneGroup(headge);
    //         curr2 = headge;
    //         headge = curr1;
    //         temp = 0;
    //     } else {
    //         curr2.next = headge;
    //     }

    //     return dummy.next;
    // }
 }
