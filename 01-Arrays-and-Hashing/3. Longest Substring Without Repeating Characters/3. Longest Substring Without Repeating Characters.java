1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int left = 0;
4        int maxLen = 0;
5        int[] last = new int[128];
6
7        for (int i = 0; i < 128; i++) last[i] = -1;
8
9        for (int right = 0; right < s.length(); right++) {
10            char c = s.charAt(right);
11            if (last[c] >= left) left = last[c] + 1;
12            last[c] = right;
13            maxLen = Math.max(maxLen, right - left + 1);
14        }
15
16        return maxLen;
17    }
18}