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
12    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
13        if(head1 == null || head2 == null) {
14            return head1 == null ? head2 : head1;
15        }
16        if(head1.val <= head2.val) {
17            head1.next = mergeTwoLists(head1.next,head2);
18            return head1;
19        }else {
20            head2.next = mergeTwoLists(head1,head2.next);
21            return head2;
22        }
23    }
24}