1
2class Solution {
3    public String minWindow(String s, String t) {
4        int n = s.length();
5        int m = t.length();
6        if (n < m) return ;
7        int left = 0;
8        int minLen = Integer.MAX_VALUE;
9        int startIdx = -1;
10        int[] freq = new int[256];
11        int count = m;
12
13        for (int i = 0; i < m; i++) {
14            freq[t.charAt(i)]++;
15        }
16        for (int right = 0; right < n; right++) {
17            if (freq[s.charAt(right)] > 0) {
18                count--;
19            }
20            freq[s.charAt(right)]--;
21            while (count == 0) {
22                if (right - left + 1 < minLen) {
23                    minLen = right - left + 1;
24                    startIdx = left;
25                }
26                freq[s.charAt(left)]++;
27                if (freq[s.charAt(left)] > 0) {
28                    count++;
29                }
30
31                left++;
32            }
33        }
34
35        return startIdx == -1 ?  : s.substring(startIdx, startIdx + minLen);
36    }
37}
38