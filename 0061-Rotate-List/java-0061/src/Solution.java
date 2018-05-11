/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        ListNode p1 = head;
        ListNode p2 = head;


        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;

        }

        System.out.println(p1.val);
        System.out.println(p2.val);

        p2.next = head;
        head = p1.next;

        p1.next = null;

        return head;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = new ListNode(arr);
        System.out.println(head);


        (new Solution()).rotateRight(head, 2);
        System.out.println(head);
    }
}
