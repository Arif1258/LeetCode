1class Solution {
2    public String maxSumOfSquares(int num, int sum) {
3        if ((long) num * 9 < sum) {
4            return ;
5        }
6        StringBuilder ans = new StringBuilder();
7        int nines = sum / 9;
8        int remainder = sum % 9;
9        ans.append(9.repeat(nines));
10
11        if (remainder > 0) {
12            ans.append(remainder);
13        }
14        while (ans.length() < num) {
15            ans.append('0');
16        }
17
18        return ans.toString();
19    }
20}