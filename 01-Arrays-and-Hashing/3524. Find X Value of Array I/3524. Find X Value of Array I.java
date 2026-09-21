1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3        long[] answer = new long[k];
4        long[] prev = new long[k];
5
6        for (int num : nums) {
7            long[] curr = new long[k];
8            int rem = num % k;
9            curr[rem]++;
10            for (int x = 0; x < k; x++) {
11                if (prev[x] > 0) {
12                    int newRem = (x * rem) % k;
13                    curr[newRem] += prev[x];
14                }
15            }
16            for (int x = 0; x < k; x++) {
17                answer[x] += curr[x];
18            }
19
20            prev = curr;
21        }
22
23        return answer;
24    }
25}