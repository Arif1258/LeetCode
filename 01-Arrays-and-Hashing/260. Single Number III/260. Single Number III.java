1class Solution {
2    public int[] singleNumber(int[] nums) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        int ans [] = new int[2];
5        int i=0;
6
7        for(int num : nums){
8            map.put(num, map.getOrDefault(num,0)+1);
9        }
10
11        for(int num : nums){
12            if(map.get(num) != 2){
13                ans[i++] = num;
14            }
15        }
16        return ans;
17        
18    }
19}