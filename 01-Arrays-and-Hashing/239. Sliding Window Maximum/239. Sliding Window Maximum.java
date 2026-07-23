1import java.util.*;
2
3class Solution {
4    public int[] maxSlidingWindow(int[] nums, int k) {
5        Deque<Integer> dq = new ArrayDeque<>();
6        int res[] = new int[nums.length - k + 1];
7        int j = 0;
8
9        for (int i = 0; i < k; i++) {
10            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
11                dq.pollLast();
12            }
13            dq.offerLast(i);
14        }
15        for (int i = k; i < nums.length; i++) {
16            res[j++] = nums[dq.peekFirst()];
17
18            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
19                dq.pollFirst();
20            }
21            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
22                dq.pollLast();
23            }
24            dq.offerLast(i);
25        }
26        res[j] = nums[dq.peekFirst()];
27        return res;
28    }
29}