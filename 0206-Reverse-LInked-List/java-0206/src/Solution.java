import jdk.internal.dynalink.linker.LinkerServices;

import javax.xml.soap.Node;
import java.util.LinkedList;

//Definition for singly-linked list.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */




class Solution {
    //public class ListNode {
    //    int val;
    //    ListNode next;
    //    ListNode(int x) { val = x; }
    //}

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;

        ListNode cur = head;

        while (cur != null){

            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;


        }

        return pre;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        ListNode node = new ListNode(nums);
        System.out.println(node);
        ListNode newNode = (new Solution()).reverseList(node);
        System.out.println(newNode);
    }

}


