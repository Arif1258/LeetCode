1class Solution {
2
3    private void findCombinations(int ind, int k, int target,
4                                  List<List<Integer>> ans,
5                                  List<Integer> ds) {
6
7        if (ds.size() == k) {
8            if (target == 0) {
9                ans.add(new ArrayList<>(ds));
10            }
11            return;
12        }
13
14        if (ind > 9 || target < 0) {
15            return;
16        }
17
18        ds.add(ind);
19        findCombinations(ind + 1, k, target - ind, ans, ds);
20        ds.remove(ds.size() - 1);
21        findCombinations(ind + 1, k, target, ans, ds);
22    }
23
24    public List<List<Integer>> combinationSum3(int k, int n) {
25
26        List<List<Integer>> ans = new ArrayList<>();
27        findCombinations(1, k, n, ans, new ArrayList<>());
28        return ans;
29    }
30}
31