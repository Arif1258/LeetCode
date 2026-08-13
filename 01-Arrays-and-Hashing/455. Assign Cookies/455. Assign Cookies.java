1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        Arrays.sort(g);
4        Arrays.sort(s);
5
6        int i = 0; 
7        int j = 0; 
8
9        while (i < g.length && j < s.length) {
10            if (s[j] >= g[i]) {
11                i++; 
12            }j++;
13        }
14
15        return i;
16    }
17}