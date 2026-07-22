1class Solution {
2    public boolean isSubsequence(String s, String t) {
3        int left = 0;
4        int right = 0;
5
6        while(left < s.length() && right < t.length()){
7            if(s.charAt(left) == t.charAt(right)){
8                left++;
9            }
10            right++;
11        }
12        return s.length() == left;
13
14
15    }
16}