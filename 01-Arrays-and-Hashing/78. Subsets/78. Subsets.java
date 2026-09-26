1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        int n = nums.length;
5        int total = 1 << n;
6
7        for(int i=0; i<total;i++){
8            List<Integer> list = new ArrayList<>();
9            for(int j = 0; j<n;j++){
10                if((i & (1 << j)) != 0) {
11                    list.add(nums[j]);
12                }
13            }
14            res.add(list);
15        }
16        return res;
17    }
18}