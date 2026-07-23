1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4        if (n < 3) {
5            return n;
6        }
7        int bits = 32 - Integer.numberOfLeadingZeros(n);
8        return 1 << bits;
9    }
10}