1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode detectCycle(ListNode head) {
14        ListNode slow = head;
15        ListNode fast = head;
16        boolean isCycle = false;
17
18        while(fast != null && fast.next != null){
19            slow = slow.next;
20            fast = fast.next.next;
21            if(slow == fast){
22                isCycle = true;
23                break;
24            }
25        }
26        if(!isCycle) return null;
27
28        slow = head;
29        while(slow != fast){
30            slow = slow.next;
31            fast = fast.next;
32        }
33        return slow;
34
35    }
36}