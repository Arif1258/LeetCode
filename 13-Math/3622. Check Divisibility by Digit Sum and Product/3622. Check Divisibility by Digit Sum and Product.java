1class Solution {
2    public boolean checkDivisibility(int n) {
3        int x=n;
4        int sum=0,product=1;
5        while(x>0){
6            int r = x%10;
7            product *= r;
8            sum += r;
9
10            x=x/10;
11            
12        }
13        return n % (sum + product) == 0;
14    }
15}