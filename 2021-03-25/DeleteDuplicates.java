/* 
日期：2021-03-25
83. 删除排序链表中的重复元素
*/

/*
算法思想：遍历删除
时间复杂度：O(n)
空间复杂度：O(1)
*/

public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}



