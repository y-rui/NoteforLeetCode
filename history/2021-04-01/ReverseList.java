/* 
日期：2021-04-01
206. 反转链表
*/

/*
算法思想：迭代
时间复杂度：O(n)
空间复杂度：O(1)
*/

class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

/*
算法思想：递归
时间复杂度：O(n)
空间复杂度：O(n)
*/

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}









