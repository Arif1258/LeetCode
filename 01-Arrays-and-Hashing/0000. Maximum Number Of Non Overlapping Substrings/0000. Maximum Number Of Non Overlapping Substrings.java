1class Solution {
2    public List<String> maxNumOfSubstrings(String s) {
3        int n = s.length();
4
5        int[] first = new int[26];
6        int[] last = new int[26];
7
8        Arrays.fill(first, n);
9        Arrays.fill(last, -1);
10
11        // Find first and last occurrence of every character
12        for (int i = 0; i < n; i++) {
13            int ch = s.charAt(i) - 'a';
14
15            first[ch] = Math.min(first[ch], i);
16            last[ch] = i;
17        }
18
19        List<int[]> intervals = new ArrayList<>();
20
21        // Create the smallest valid interval for each character
22        for (int ch = 0; ch < 26; ch++) {
23            if (last[ch] == -1) {
24                continue;
25            }
26
27            int left = first[ch];
28            int right = last[ch];
29
30            boolean valid = true;
31
32            for (int i = left; i <= right; i++) {
33                int current = s.charAt(i) - 'a';
34                if (first[current] < left) {
35                    valid = false;
36                    break;
37                }
38                right = Math.max(right, last[current]);
39            }
40
41            if (valid) {
42                intervals.add(new int[]{left, right});
43            }
44        }
45
46        // Sort by ending position
47        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
48
49        List<String> answer = new ArrayList<>();
50
51        int previousEnd = -1;
52
53        for (int[] interval : intervals) {
54            if (interval[0] > previousEnd) {
55                answer.add(s.substring(interval[0], interval[1] + 1));
56                previousEnd = interval[1];
57            }
58        }
59
60        return answer;
61    }
62}