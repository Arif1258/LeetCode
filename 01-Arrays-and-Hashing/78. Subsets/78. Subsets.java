1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        int n = nums.length;
5
6        for(int i=0; i< 1<<n; i++){
7            List<Integer> list = new ArrayList<>();
8            for(int j = 0; j<n;j++){
9                if((i & (1 << j)) != 0) {
10                    list.add(nums[j]);
11                }
12            }
13            res.add(list);
14        }
15        return res;
16    }
17}