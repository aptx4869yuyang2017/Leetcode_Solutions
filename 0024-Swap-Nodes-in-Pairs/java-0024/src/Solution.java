/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null)
            return null;
        else if (head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode pre = new ListNode(0);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode then = new ListNode(0);

        dummy = pre;
        node1 = head;


        while (node1 != null && node1.next != null){


            node2 = node1.next;
            then = node2.next;


            pre.next = node2;
            node2.next = node1;
            node1.next = then;

            pre = node1;
            node1 = then;

        }

        return dummy.next;

    }

    public static void main(String[] args) {

        int[] arr = {1};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution()).swapPairs(null);
        System.out.println(head);

    }
}
