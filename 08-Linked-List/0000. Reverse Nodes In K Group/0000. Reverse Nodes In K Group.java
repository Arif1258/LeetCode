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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        ListNode temp = head;
14        int count = 0;
15        // check if it is lees than k value 
16        while(count < k) {
17            if(temp == null){
18                return head;
19            }
20            temp = temp.next;
21            count++;
22        }
23        // recursive call for rest of the linkedList
24        ListNode prevNode = reverseKGroup(temp,k);
25
26        //reverse current group
27        temp = head;
28        count = 0;
29        while(count < k){
30            ListNode next = temp.next;
31            temp.next = prevNode;
32            prevNode = temp;
33            temp = next;
34            count++;
35        }
36        return prevNode;
37    }
38}