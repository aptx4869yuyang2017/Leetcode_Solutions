/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode li = new ListNode(0);
        ListNode gr = new ListNode(0);


        ListNode cur = head;
        ListNode pre1 = li;
        ListNode pre2 = gr;
        while (cur != null){
            if (cur.val < x){
                pre1.next = cur;
                pre1 = cur;
                cur = cur.next;
            }else {
                pre2.next = cur;
                pre2 = cur;
                cur = cur.next;
            }
        }

        pre1.next = gr.next;
        pre2.next = null;

        return li.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        int[] nums2 = new int[]{1, 99, 2, 33};

        ListNode list1 = new ListNode(nums);
        ListNode list2 = new ListNode(nums2);

        System.out.println((new Solution()).partition(list1, 2));
        System.out.println((new Solution()).partition(list2, 15));
    }
}
