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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k=k%length;
        for (int i = 0; i < k; i++) {
            head = rotate(head);
        }
        return head;
    }

    public ListNode rotate(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head.next;
        ListNode prev = head;
        while (curr.next != null) {

            curr = curr.next;
            prev = prev.next;
        }
        curr.next = head;
        head = curr;
        prev.next = null;

        return head;
    }
}
