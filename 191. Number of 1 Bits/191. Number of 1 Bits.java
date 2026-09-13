1class Solution {
2    public int hammingWeight(int n) {
3        int count = 0;
4        while(n != 0){
5            count++;
6            n = n & (n-1);
7
8        }
9        return count;
10    }
11}