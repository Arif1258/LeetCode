1class Solution {
2    public int findKthPositive(int[] arr, int k) {
3        int left = 0, right = arr.length;
4        while(left < right){
5            int mid = left + (right-left)/2;
6            int missing = arr[mid] - (mid+1);
7            if(missing < k) left = mid+1;
8            else right = mid;
9        }
10        return left+k;
11    }
12}