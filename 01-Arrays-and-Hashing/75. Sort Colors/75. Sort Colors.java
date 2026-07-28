1class Solution {
2    public void sortColors(int[] nums) {
3        int low = 0;  
4        int mid = 0;          
5        int high = nums.length - 1; 
6
7        while (mid <= high) {
8            if (nums[mid] == 0) {
9               
10                int temp = nums[low];
11                nums[low] = nums[mid];
12                nums[mid] = temp;
13
14                low++;
15                mid++;
16            } else if (nums[mid] == 1) {
17                mid++;  
18            } else {
19                
20                int temp = nums[mid];
21                nums[mid] = nums[high];
22                nums[high] = temp;
23
24                high--;
25            }
26        }
27    }
28}
29