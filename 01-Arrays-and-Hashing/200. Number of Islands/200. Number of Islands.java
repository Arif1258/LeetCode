1class Solution {
2    void dfs(int i, int j, boolean vis[][],char grid[][], int n, int m){
3        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] != '1')
4            return;
5
6        vis[i][j] = true;
7        dfs(i-1,j,vis,grid,n,m);
8        dfs(i+1,j,vis,grid,n,m);
9        dfs(i,j-1,vis,grid,n,m);
10        dfs(i,j+1,vis,grid,n,m);
11    }
12    public int numIslands(char[][] grid) {
13        int islands = 0;
14        int n = grid.length;
15        int m = grid[0].length;
16        boolean vis[][] = new boolean[n][m];
17
18        for(int i=0; i<n;i++){
19            for(int j=0;j<m;j++){
20                if(grid[i][j] == '1' && !vis[i][j]){
21                    dfs(i,j,vis,grid,n,m);
22                    islands++;
23                }
24            }
25        }
26        return islands;
27
28    }
29}