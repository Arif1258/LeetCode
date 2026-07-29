1import java.util.*;
2
3class Solution {
4    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
5        Stack<Integer> stack = new Stack<>();
6        HashMap<Integer, Integer> map = new HashMap<>();
7
8        for (int i = nums2.length - 1; i >= 0; i--) {
9            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
10                stack.pop();
11            }
12
13            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
14            stack.push(nums2[i]);
15        }
16
17        int[] ans = new int[nums1.length];
18
19        for (int i = 0; i < nums1.length; i++) {
20            ans[i] = map.get(nums1[i]);
21        }
22
23        return ans;
24    }
25}