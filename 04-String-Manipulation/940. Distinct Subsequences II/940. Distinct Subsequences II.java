1class Solution {
2    public int distinctSubseqII(String s) {
3        long MOD = 1_000_000_007L;
4
5        long[] dp = new long[s.length() + 1];
6        int[] last = new int[26];
7        java.util.Arrays.fill(last, -1);
8
9        dp[0] = 1;
10
11        for (int i = 1; i <= s.length(); i++) {
12            int ch = s.charAt(i - 1) - 'a';
13
14            dp[i] = (2 * dp[i - 1]) % MOD;
15
16            if (last[ch] != -1) {
17                dp[i] = (dp[i] - dp[last[ch]] + MOD) % MOD;
18            }
19            last[ch] = i - 1;
20        }
21        return (int) ((dp[s.length()] - 1 + MOD) % MOD);
22    }
23}
24
25