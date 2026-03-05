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
    public int pairSum(ListNode head) {
        
        
        ArrayList<Integer> list=new ArrayList<>();

        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }

        int n=list.size();
        int maxsum=0;

        
        for(int i=0;i<n/2;i++){
            int sum=list.get(i)+list.get(n-1-i);
            maxsum=Math.max(maxsum,sum);
        }

        return maxsum;

    }
}