1class Solution {
2    public int[] findPeakGrid(int[][] mat) {
3        int n = mat.length;
4        int m = mat[0].length;
5        int max = -2;
6        int ans [] = new int [2];
7
8        for(int i=0; i<n;i++){
9            for(int j=0; j<m;j++){
10                if(mat[i][j] > max){
11                    max = mat[i][j];
12                    ans = new int[]{i,j};
13                }
14            }
15        }
16        return ans;
17    }
18}