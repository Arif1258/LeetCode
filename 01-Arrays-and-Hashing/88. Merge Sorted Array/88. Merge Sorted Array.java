1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        int i = m-1;
4        int j = n-1;
5        int k = m+n-1;
6
7        while(i >= 0 && j >= 0){
8            if(nums2[j] >= nums1[i]){
9                nums1[k] = nums2[j];
10                k--;j--;
11            }else{
12                nums1[k] = nums1[i];
13                i--;k--;
14            }
15        }
16        while( j>=0){
17            nums1[k] = nums2[j];
18            k--;j--;
19        }
20    }
21}