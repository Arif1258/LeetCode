1
2class Solution {
3    public int maxLength(int[] nums) {
4        int n = nums.length;
5        int ans = 0;
6
7        for (int i = 0; i < n; i++) {
8            long product = 1;
9            long gcd = 0;
10            long lcm = 1;
11
12            for (int j = i; j < n; j++) {
13                product *= nums[j];
14
15                gcd = gcd(gcd, nums[j]);
16                lcm = lcm(lcm, nums[j]);
17
18                if (product == gcd * lcm) {
19                    ans = Math.max(ans, j - i + 1);
20                }
21            }
22        }
23
24        return ans;
25    }
26
27    private long gcd(long a, long b) {
28        while (b != 0) {
29            long temp = b;
30            b = a % b;
31            a = temp;
32        }
33        return a;
34    }
35
36    private long lcm(long a, long b) {
37        return (a / gcd(a, b)) * b;
38    }
39}
40