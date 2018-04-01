/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode pre = dummy;

        int shift = 0;

        while (cur1 != null || cur2 != null){

            ListNode temp = new ListNode(0);
            pre.next = temp;

            int sum = (cur1 == null ? 0 : cur1.val)+ (cur2 == null ? 0 :cur2.val) + shift;
            temp.val = sum % 10;
            shift = sum / 10;

            if (cur1 != null)
                cur1 = cur1.next;
            if (cur2 != null)
                cur2 = cur2.next;
            pre = temp;

        }

        if (shift == 1){
            ListNode tail = new ListNode(1);
            tail.next = null;
            pre.next = tail;
        }



        return dummy.next;

    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{9, 9};

        ListNode list1 = new ListNode(nums1);
        ListNode list2 = new ListNode(nums2);

        System.out.println((new Solution()).addTwoNumbers(list1, list2));

    }
}
