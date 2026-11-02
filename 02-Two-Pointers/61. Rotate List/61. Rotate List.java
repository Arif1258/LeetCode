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
12    public ListNode rotateRight(ListNode head, int k) {
13        if(head == null || head.next == null || k == 0) return head;
14        ListNode curr = head;
15        int n = 1;
16
17        while(curr.next != null){
18            curr = curr.next;
19            n++;
20        }
21        k = k%n;
22        if(k == 0) return head;
23        curr.next = head;
24        int steps = n-k;
25        ListNode newTail = head;
26        for(int i=1; i<steps;i++){
27            newTail = newTail.next;
28        }
29        ListNode newhead = newTail.next;
30        newTail.next=null;
31        return newhead;
32    }
33}