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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr=head.next;
        ListNode prev=curr;


        while(prev!=null){
            int c=0;
            while(prev.val!=0){
                c+=prev.val;
                prev=prev.next;
            }

            curr.val=c;

            prev=prev.next;

            curr.next=prev;

            curr=curr.next;
        }
        return head.next;
    }
}