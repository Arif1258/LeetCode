1class Solution {
2    public int maxProductDifference(int[] a) {
3        Arrays.sort(a);
4        int n = a.length;
5        return a[n-1] * a[n-2] - a[0] * a[1];
6    }
7}