1class Solution {
2
3    private void findCombinations(int ind, int arr [], int target, List<List<Integer>> ans, List<Integer> ds){
4
5        if(ind == arr.length) {
6            if(target == 0) ans.add(new ArrayList<>(ds));
7            return;
8        }
9        if(arr[ind] <= target){
10            ds.add(arr[ind]);
11            findCombinations(ind, arr, target-arr[ind], ans, ds);
12            ds.remove(ds.size()-1);
13        }
14        findCombinations(ind+1,arr, target, ans, ds);
15    }
16
17
18    public List<List<Integer>> combinationSum(int[] candidates, int target) {
19        List<List<Integer>> ans = new ArrayList<>();
20        findCombinations(0, candidates, target, ans, new ArrayList<>());
21        return ans;
22
23    }
24}