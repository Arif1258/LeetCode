1import java.util.*;
2
3class Solution {
4    public String largestNumber(int[] nums) {
5        String[] arr = new String[nums.length];
6
7        for (int i = 0; i < nums.length; i++) {
8            arr[i] = String.valueOf(nums[i]);
9        }
10
11        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
12        if (arr[0].equals(0)) {
13            return 0;
14        }
15        
16        StringBuilder ans = new StringBuilder();
17
18        for (String s : arr) {
19            ans.append(s);
20        }
21
22        return ans.toString();
23    }
24}