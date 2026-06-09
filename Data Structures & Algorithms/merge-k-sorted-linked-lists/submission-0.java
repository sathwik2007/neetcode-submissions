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
    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode curr = res;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while(l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while(l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        return res.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) {
            return null;
        }
        while(lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i = 0; i < lists.length; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(mergeLists(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }
}
