1class Solution {
2    public ListNode sortList(ListNode head) {
3        if (head == null || head.next == null) return head;
4
5        ListNode slow = head, fast = head, prev = null;
6
7        while (fast != null && fast.next != null) {
8            prev = slow;
9            slow = slow.next;
10            fast = fast.next.next;
11        }
12
13        prev.next = null;
14
15        ListNode l1 = sortList(head);
16        ListNode l2 = sortList(slow);
17
18        return merge(l1, l2);
19    }
20
21    private ListNode merge(ListNode a, ListNode b) {
22        if (a == null) return b;
23        if (b == null) return a;
24
25        if (a.val <= b.val) {
26            a.next = merge(a.next, b);
27            return a;
28        }
29
30        b.next = merge(a, b.next);
31        return b;
32    }
33}