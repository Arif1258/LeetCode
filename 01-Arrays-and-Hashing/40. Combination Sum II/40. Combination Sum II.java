1class Solution {
2    private void findCombinations(int ind, int[] arr, int target,
3                                  List<List<Integer>> ans,
4                                  List<Integer> ds) {
5
6        if (target == 0) {
7            ans.add(new ArrayList<>(ds));
8            return;
9        }
10
11        if (ind == arr.length || target < 0) {
12            return;
13        }
14        ds.add(arr[ind]);
15        findCombinations(ind + 1, arr, target - arr[ind], ans, ds);
16        ds.remove(ds.size() - 1);
17
18        int next = ind + 1;
19        while (next < arr.length && arr[next] == arr[ind]) {
20            next++;
21        }
22        findCombinations(next, arr, target, ans, ds);
23    }
24
25    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
26
27        List<List<Integer>> ans = new ArrayList<>();
28        Arrays.sort(candidates);
29        findCombinations(0, candidates, target, ans, new ArrayList<>());
30
31        return ans;
32    }
33}