1class Solution {
2    public int numOfSubarrays(int[] arr) {
3        int MOD = 1_000_000_007;
4
5        long even = 1;
6        long odd = 0;
7        long count = 0;
8        int prefixSum = 0;
9
10        for (int num : arr) {
11            prefixSum += num;
12
13            if (prefixSum % 2 == 0) {
14                count += odd;
15                even++;
16            } else {
17                count += even;
18                odd++;
19            }
20
21            count %= MOD;
22        }
23
24        return (int) count;
25    }
26}