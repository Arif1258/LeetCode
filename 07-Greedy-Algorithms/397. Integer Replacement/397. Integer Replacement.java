1class Solution {
2    public int integerReplacement(int n) {
3        int operations = 0;
4        long num = n;
5
6        while(num != 1){
7            if((num & 1) == 0) num = num/2;
8            else{
9                if(num == 3 || num %4 == 1) num--;
10                else num++;
11            }
12            operations++;
13        }
14        return operations;
15    }
16}