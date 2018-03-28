import java.util.List;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < m; i++)
            pre = pre.next;

        ListNode cur = pre.next;

        ListNode letf = pre;
        ListNode right = pre.next;

        for (int i = m; i <= n; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        letf.next = pre;
        right.next = cur;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println((new Solution()).reverseBetween(new ListNode(nums), 2, 4));
    }
}
