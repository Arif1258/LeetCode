1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int[] ans = new int[seq.length()];
4        int depth = 0;
5
6        for (int i = 0; i < seq.length(); i++) {
7            char ch = seq.charAt(i);
8
9            if (ch == '(') {
10                depth++;
11                ans[i] = depth % 2;
12            } else {
13                ans[i] = depth % 2;
14                depth--;
15            }
16        }
17
18        return ans;
19    }
20}