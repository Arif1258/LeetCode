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
12    public ListNode oddEvenList(ListNode head) {
13        if(head == null || head.next == null) return head;
14
15        ListNode odd = head;
16        ListNode even = head.next;
17        ListNode evenHead = even;
18
19        while(even != null && even.next != null){
20            odd.next = even.next;
21            odd = odd.next;
22
23            even.next = odd.next;
24            even = even.next;
25        }
26        odd.next = evenHead;
27        return head;
28    }
29}