1class Solution {
2    public int beautySum(String s) {
3        int ans = 0;
4
5        for (int i = 0; i < s.length(); i++) {
6            int[] freq = new int[26];
7
8            for (int j = i; j < s.length(); j++) {
9                freq[s.charAt(j) - 'a']++;
10
11                int max = 0;
12                int min = Integer.MAX_VALUE;
13
14                for (int k = 0; k < 26; k++) {
15                    if (freq[k] > 0) {
16                        max = Math.max(max, freq[k]);
17                        min = Math.min(min, freq[k]);
18                    }
19                }
20
21                ans += max - min;
22            }
23        }
24
25        return ans;
26    }
27}