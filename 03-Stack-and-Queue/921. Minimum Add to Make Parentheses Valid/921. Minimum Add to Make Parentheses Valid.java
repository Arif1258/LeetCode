1class Solution {
2    public int minAddToMakeValid(String s) {
3        int balance = 0;
4        int additions = 0;
5
6        for (char ch : s.toCharArray()) {
7            if (ch == '(') {
8                balance++;
9            } else {
10                if (balance > 0) {
11                    balance--;
12                } else {
13                    additions++;
14                }
15            }
16        }
17
18        return additions + balance;
19    }
20}