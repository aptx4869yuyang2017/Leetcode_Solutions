/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 先计算两个链表的长度
        int n1 = length(l1);
        int n2 = length(l2);


        // 给短的链表前面补上零保证两个链表一样长，方便计算
        if (n1 > n2) {
            l2 = addZero(l2, n1-n2);
        }
        else if (n1 < n2) {
            l1 = addZero(l1, n2-n1);
        }

        // 设定两个指针，用于遍历两个链表
        ListNode cur1 = new ListNode(0);
        ListNode cur2 = new ListNode(0);


        // assert length(l1) == length(l2);

        cur1.next = l1;
        cur2.next = l2;

        // res 用来记录返回链表的头结点
        ListNode res = new ListNode(0);
        // pre 指针作用，用于更新res list 每一位的计算
        ListNode pre = res;

        // memo 用来记录进位的情况  memo[i] 是第i位加和后是否进位 0是不需要给位进位，1是需要
        int n = Math.max(n1 , n2);
        int[] memo = new int[n+1];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        int index = 1;

        while (cur1 != null && cur2 != null){

            ListNode temp = new ListNode(0);
            int sum = cur1.val + cur2.val + shift(cur1, cur2, memo, index++);
            if (sum >= 10 && index == 0)
                pre.val ++;

            temp.val = sum % 10;

            pre.next = temp;
            pre = temp;

            cur1 = cur1.next;
            cur2 = cur2.next;



        }

        if (res.val == 1)
            return res;
        else if (res.val == 0 && res.next.val == 0)
            return res.next.next;
        else
            return res.next;

    }

    public ListNode addZero(ListNode head, int n){

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int i = 0; i < n; i++) {
            ListNode temp = new ListNode(0);
            temp.next = dummy.next;
            dummy.next= temp;

        }

        return dummy.next;

    }


    // shift 状态定义 下一位的进位状态 index 是当前的位置
    public int shift(ListNode node1, ListNode node2, int[] memo, int index){

        if (memo[index] != -1)
            return memo[index];


        if (node1.next != null && node2.next != null){
            int sum = node1.next.val + node2.next.val + shift(node1.next, node2.next, memo, index+1);
            memo[index] = sum/10;
        }else {
            memo[index] = 0;
        }

        return memo[index];

    }

    public int length(ListNode head){
        int res = 1;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{9, 9, 9};
        int[] nums2 = new int[]{2};

        ListNode list1 = new ListNode(nums1);
        ListNode list2 = new ListNode(nums2);

        System.out.println((new Solution2()).addTwoNumbers(list1, list2));

    }
}
