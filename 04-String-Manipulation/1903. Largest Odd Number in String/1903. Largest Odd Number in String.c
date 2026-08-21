1class Solution {
2    public String largestOddNumber(String num) {
3        for (int i = num.length() - 1; i >= 0; i--) {
4            int digit = num.charAt(i) - '0';
5            
6            if (digit % 2 != 0) {
7                return num.substring(0, i + 1);
8            }
9        }
10
11        return ;
12    }
13}