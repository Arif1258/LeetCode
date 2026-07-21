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
12    public ListNode removeElements(ListNode head, int val) {
13        ListNode temp = new ListNode(-1);
14        temp.next = head;
15        ListNode curr = head;
16        ListNode prev = temp;
17
18        while(curr != null){
19            if(curr.val == val){
20                prev.next = curr.next;
21            }
22            else{
23                prev = curr;
24            }
25            curr = curr.next;
26        }
27        return temp.next;
28    }
29}