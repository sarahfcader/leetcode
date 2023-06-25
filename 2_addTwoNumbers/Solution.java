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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // O(n), where n is the length of the longer linked list.
        
        int carry = 0;
        ListNode solutionHead = new ListNode(-1);
        ListNode current = solutionHead;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = carry;
            carry = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            }
            
            current.next = new ListNode(sum);
            current = current.next;
        }

        return solutionHead.next;

    }
}