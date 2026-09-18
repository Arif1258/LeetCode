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
12    public ListNode mergeKLists(ListNode[] lists) {
13
14        if (lists == null || lists.length == 0) {
15            return null;
16        }
17
18        PriorityQueue<ListNode> pq =
19            new PriorityQueue<>((a, b) -> a.val - b.val);
20
21        // Add first node of every list
22        for (ListNode head : lists) {
23            if (head != null) {
24                pq.offer(head);
25            }
26        }
27        ListNode dummy = new ListNode(0);
28        ListNode current = dummy;
29
30        while (!pq.isEmpty()) {
31
32            ListNode smallest = pq.poll();
33
34            current.next = smallest;
35            current = current.next;
36            if (smallest.next != null) {
37                pq.offer(smallest.next);
38            }
39        }
40        return dummy.next;
41    }
42}