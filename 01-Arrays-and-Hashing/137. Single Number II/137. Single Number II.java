1class Solution {
2    public int singleNumber(int[] nums) {
3        int n = nums.length;
4
5        HashMap<Integer, Integer> map = new HashMap<>();
6        for(int num : nums){
7            map.put(num, map.getOrDefault(num,0) + 1);
8        }
9        for(int num : nums){
10            if(map.get(num) == 1) return num;
11        }
12        return -1;
13    }
14}