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
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        if(length == n) {
            return head.next;
        }
        int index = 0;
        curr = head;
        while(curr != null) {
            if((index + 1) == (length - n)) {
                curr.next = curr.next.next;
                return head;
            } else {
                index++;
                curr = curr.next;
            }
        }
        return head;
    }
}
