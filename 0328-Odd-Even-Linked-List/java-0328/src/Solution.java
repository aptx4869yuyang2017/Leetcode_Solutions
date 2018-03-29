/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);

        ListNode preOdd = odd;
        ListNode preEven = even;

        ListNode cur = head;
        boolean isEven = false;
        while (cur != null){

            if (isEven){
                preEven.next = cur;
                preEven = cur;
            }else {
                preOdd.next = cur;
                preOdd = cur;
            }
            isEven = !isEven;
            cur = cur.next;

        }

        preOdd.next = even.next;
        preEven.next = null;

        return odd.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{0, 0, 0};

        ListNode list1 = new ListNode(nums);
        ListNode list2 = new ListNode(nums2);

        System.out.println((new Solution()).oddEvenList(list1));
        System.out.println((new Solution()).oddEvenList(list2));

    }
}