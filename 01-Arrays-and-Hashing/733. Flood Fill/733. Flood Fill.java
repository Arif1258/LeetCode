1class Solution {
2    public void dfs(int[][] image, int i, int j, int newColor, int orgColor){
3        if(i <0 || j<0|| i>=image.length || j>=image[0].length || image[i][j] == newColor || image[i][j] != orgColor) return;
4
5        image[i][j] = newColor;
6
7        dfs(image, i+1,j,newColor, orgColor);
8        dfs(image, i-1,j,newColor, orgColor);
9        dfs(image, i,j+1,newColor, orgColor);
10        dfs(image, i,j-1,newColor, orgColor);
11    }
12    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
13        dfs(image, sr, sc, color, image[sr][sc]);
14        return image;
15    }
16}