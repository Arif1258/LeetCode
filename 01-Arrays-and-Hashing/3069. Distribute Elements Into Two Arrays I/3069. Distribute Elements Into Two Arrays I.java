1class Solution {
2    public int[] resultArray(int[] nums) {
3
4        ArrayList<Integer> arr1 = new ArrayList<>();
5        ArrayList<Integer> arr2 = new ArrayList<>();
6
7        arr1.add(nums[0]);
8        arr2.add(nums[1]);
9
10        for (int i = 2; i < nums.length; i++) {
11
12            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
13                arr1.add(nums[i]);
14            } else {
15                arr2.add(nums[i]);
16            }
17        }
18
19        int[] ans = new int[nums.length];
20
21        int k = 0;
22
23        for (int x : arr1) {
24            ans[k++] = x;
25        }
26
27        for (int x : arr2) {
28            ans[k++] = x;
29        }
30
31        return ans;
32    }
33}