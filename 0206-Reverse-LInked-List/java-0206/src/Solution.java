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

        while (cur.next != null){

            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;


        }

        return pre;

    }

    //public void printLinkList(ListNode head){
    //
    //    ListNode p = head;
    //
    //    while (p.next != null){
    //        System.out.println(p.val + "->");
    //        p = p.next;
    //    }
    //}
    //
    //public ListNode creatLinkList(int[] nums){
    //
    //    ListNode head = new ListNode(nums[0]);
    //    ListNode p;
    //    head.next = p;
    //    ListNode pre;
    //
    //    for (int i = 1; i < nums.length; i++) {
    //        p.val = nums[i];
    //
    //    }
    //}
    //
    //public static void main(String[] args) {
    //
    //}
}


