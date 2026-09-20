1class Solution {
2    public int reverseDegree(String s) {
3        int ans = 0;
4        for(int i=0; i<s.length();i++){
5            int rev = ('z' - s.charAt(i)+1);
6            ans += rev * (i+1);
7        }
8        return ans;
9    }
10}