1
2class Solution {
3    private static final int MOD = 1_000_000_007;
4    private long[][] comb;
5
6    public int numOfWays(int[] nums) {
7        int n = nums.length;
8        comb = new long[n + 1][n + 1];
9        for (int i = 0; i <= n; i++) {
10            comb[i][0] = comb[i][i] = 1;
11            for (int j = 1; j < i; j++) {
12                comb[i][j] = (comb[i - 1][j - 1]
13                        + comb[i - 1][j]) % MOD;
14            }
15        }
16
17        return (int) ((countWays(nums) - 1 + MOD) % MOD);
18    }
19
20    private long countWays(int[] nums) {
21        int n = nums.length;
22        if (n <= 2) {
23            return 1;
24        }
25        int root = nums[0];
26        java.util.List<Integer> left = new java.util.ArrayList<>();
27        java.util.List<Integer> right = new java.util.ArrayList<>();
28        for (int i = 1; i < n; i++) {
29            if (nums[i] < root) {
30                left.add(nums[i]);
31            } else {
32                right.add(nums[i]);
33            }
34        }
35        long leftWays = countWays(
36                left.stream().mapToInt(Integer::intValue).toArray()
37        );
38        long rightWays = countWays(
39                right.stream().mapToInt(Integer::intValue).toArray()
40        );
41        long interleavings = comb[n - 1][left.size()];
42
43        return (((interleavings * leftWays) % MOD) * rightWays) % MOD;
44    }
45}
46