1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int row = 0;
4        int col = matrix[0].length-1;
5
6        while(row < matrix.length && col >= 0){
7            if(matrix[row][col] == target) return true;
8            else if(matrix[row][col] < target){
9                row++;
10            }else{
11                col--;
12            }
13        }
14        return false;
15    }
16}