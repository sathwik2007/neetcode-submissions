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
         ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = head1;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head1 = prev;

        curr = head;
        while(head1 != null) {
            ListNode headNext = curr.next;
            ListNode head1Next = head1.next;
            curr.next = head1;
            head1.next = headNext;
            curr = headNext;
            head1 = head1Next;
        }
    }
}
