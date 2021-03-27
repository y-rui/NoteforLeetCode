/* 
日期：2021-03-26
141. 环形链表
*/

/*
算法思想：哈希表
思路：遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过
时间复杂度：O(n)
空间复杂度：O(n)
*/

public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

/*
算法思想：快慢指针
思路：我们定义两个指针，一快一满。
慢指针每次只移动一步，而快指针每次移动两步。
初始时，慢指针在位置 head，而快指针在位置 head.next。
这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。
否则快指针将到达链表尾部，该链表不为环形链表。
时间复杂度：O(n)
空间复杂度：O(1)
*/

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}















