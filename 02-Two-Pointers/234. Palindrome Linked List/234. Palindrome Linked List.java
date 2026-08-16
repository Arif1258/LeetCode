1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public boolean isPalindrome(ListNode head) {
13        if (head == null || head.next == null) {
14            return true;
15        }
16        ListNode slow = head;
17        ListNode fast = head;
18        while (fast != null && fast.next != null) {
19            slow = slow.next;
20            fast = fast.next.next;
21        }
22        if (fast != null) {
23            slow = slow.next;
24        }
25        ListNode prev = null;
26        while (slow != null) {
27            ListNode next = slow.next;
28            slow.next = prev;
29            prev = slow;
30            slow = next;
31        }
32        ListNode left = head;
33        ListNode right = prev;
34        while (right != null) {
35            if (left.val != right.val) {
36                return false;
37            }
38            left = left.next;
39            right = right.next;
40        }
41
42        return true;
43    }
44}