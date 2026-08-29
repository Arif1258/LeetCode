1import java.util.*;
2
3class Solution {
4    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
5        int n = nums.length;
6
7        Integer[] idx = new Integer[n];
8
9        for (int i = 0; i < n; i++) {
10            idx[i] = i;
11        }
12
13        Arrays.sort(idx, (a, b) -> Integer.compare(nums[a], nums[b]));
14
15        int[] ans = new int[n];
16
17        int i = 0;
18
19        while (i < n) {
20            int j = i + 1;
21
22            while (j < n &&
23                   nums[idx[j]] - nums[idx[j - 1]] <= limit) {
24                j++;
25            }
26
27            List<Integer> positions = new ArrayList<>();
28
29            for (int k = i; k < j; k++) {
30                positions.add(idx[k]);
31            }
32
33            Collections.sort(positions);
34
35            for (int k = 0; k < positions.size(); k++) {
36                ans[positions.get(k)] = nums[idx[i + k]];
37            }
38
39            i = j;
40        }
41
42        return ans;
43    }
44}