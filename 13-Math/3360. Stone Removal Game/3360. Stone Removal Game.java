1class Solution {
2    public boolean canAliceWin(int n) {
3        int stones = 10;
4        boolean alice = true;
5
6        while (n >= stones && stones > 0) {
7            n -= stones;
8            stones--;
9            alice = !alice;
10        }
11
12        return !alice;
13    }
14}
15