1class Solution {
2    public int longestStrChain(String[] words) {
3        Arrays.sort(words, (a, b) -> a.length() - b.length());
4        int n = words.length;
5        int[] dp = new int[n];
6        Arrays.fill(dp, 1);
7        int ans = 1;
8
9        for (int i = 1; i < n; i++) {
10            for (int j = 0; j < i; j++) {
11                if (words[i].length() == words[j].length() + 1
12                        && isPredecessor(words[j], words[i])) {
13                    dp[i] = Math.max(dp[i], dp[j] + 1);
14                }
15            }
16            ans = Math.max(ans, dp[i]);
17        }
18        return ans;
19    }
20    private boolean isPredecessor(String shorter, String longer) {
21        int i = 0, j = 0;
22        while (i < shorter.length() && j < longer.length()) {
23            if (shorter.charAt(i) == longer.charAt(j)) {
24                i++;
25            }
26            j++;
27        }
28        return i == shorter.length();
29    }
30}
31