1class Solution{
2    public int uniquePaths(int m,int n){
3        int[][] dp=new int[m][n];
4        for(int i=0;i<m;i++)dp[i][0]=1;
5        for(int j=0;j<n;j++)dp[0][j]=1;
6        
7        for(int i=1;i<m;i++){
8            for(int j=1;j<n;j++){
9                dp[i][j]=dp[i-1][j]+dp[i][j-1];
10            }
11        }
12        return dp[m-1][n-1];
13    }
14}