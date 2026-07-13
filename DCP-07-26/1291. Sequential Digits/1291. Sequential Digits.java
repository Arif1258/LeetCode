1import java.util.*;
2
3class Solution {
4    public List<Integer> sequentialDigits(int low, int high) {
5        List<Integer> ans = new ArrayList<>();
6        for (int i = 1; i <= 9; i++) {
7            int num = i;
8
9            for (int j = i + 1; j <= 9; j++) {
10                num = num * 10 + j;
11
12                if (num >= low && num <= high) {
13                    ans.add(num);
14                }
15            }
16        }
17        Collections.sort(ans);
18        return ans;
19    }
20}