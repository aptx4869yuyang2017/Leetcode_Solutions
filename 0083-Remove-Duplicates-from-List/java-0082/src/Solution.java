/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;

        // 因为head不可能被删除，所以不用设置dummy了， 设置了反而影响head的重复性判断

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){

            if (pre != null && cur.val == pre.val){
                cur = cur.next;
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }

        }


        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2, 2, 2, 6};
        ListNode list = new ListNode(nums);
        System.out.println((new Solution()).deleteDuplicates(list));
        //System.out.println(list);

    }
}
