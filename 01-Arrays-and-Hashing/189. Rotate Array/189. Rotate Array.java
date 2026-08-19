1class Solution {
2    public void rotate(int[] nums, int k) {
3        int n = nums.length;
4        k = k % n;
5
6        reverse(nums, 0, n - 1);
7        reverse(nums, 0, k - 1);
8        reverse(nums, k, n - 1);
9    }
10
11    private void reverse(int[] nums, int left, int right) {
12        while (left < right) {
13            int temp = nums[left];
14            nums[left] = nums[right];
15            nums[right] = temp;
16
17            left++;
18            right--;
19        }
20    }
21}