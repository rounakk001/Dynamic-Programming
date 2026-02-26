class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Edge case: agar kisi bhi list ka head null hai
        if (headA==null || headB==null) {
            return null;
        }

        ListNode A = headA;
        ListNode B = headB;

        // Jab tak dono pointers equal nahi ho jate
        while (A != B) {

            // Agar list A khatam ho gayi, to list B ke head par bhej do
            if (A == null) {
                A = headB;
            } else {
                A = A.next;
            }

            // Agar list B khatam ho gayi, to list A ke head par bhej do
            if (B == null) {
                B = headA;
            } else {
                B = B.next;
            }
        }

        // Ya to intersection node milega ya null
        return A;
    }
}