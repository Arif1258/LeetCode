1class Solution {
2
3    private void findSubsets(int ind, int[] nums,
4                             List<List<Integer>> ans,
5                             List<Integer> ds) {
6
7        if (ind == nums.length) {
8            ans.add(new ArrayList<>(ds));
9            return;
10        }
11
12        ds.add(nums[ind]);
13        findSubsets(ind + 1, nums, ans, ds);
14        ds.remove(ds.size() - 1);
15        int next = ind + 1;
16        while (next < nums.length && nums[next] == nums[ind]) {
17            next++;
18        }
19        findSubsets(next, nums, ans, ds);
20    }
21
22    public List<List<Integer>> subsetsWithDup(int[] nums) {
23        List<List<Integer>> ans = new ArrayList<>();
24        Arrays.sort(nums);
25        findSubsets(0, nums, ans, new ArrayList<>());
26        return ans;
27    }
28}