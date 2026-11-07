1class Solution {
2    public boolean searchInRow(int[][] matrix, int target, int row){
3            int n = matrix[0].length;
4            int start = 0; int end = n-1;
5
6            while(start <= end){
7                int mid = start + (end - start)/2;
8                if(target == matrix[row][mid]) return true;
9                else if(target > matrix[row][mid]) {
10                    start = mid+1;
11                }else{
12                    end = mid - 1;
13                }
14            }
15            return false;
16        }
17    public boolean searchMatrix(int[][] matrix, int target) {
18        int m = matrix.length;
19        int n = matrix[0].length;
20
21        int startRow = 0;
22        int endRow = m-1;
23
24        
25
26        while(startRow <= endRow){
27            int midRow = startRow + (endRow - startRow)/2;
28
29            if(target >= matrix[midRow][0] && target <= matrix[midRow][n-1]){
30                return searchInRow(matrix, target, midRow);
31            }else if(target >= matrix[midRow][n-1]){
32                startRow = midRow + 1;
33            }else{
34                endRow = midRow - 1;
35            }
36        }
37        return false;
38    }
39}