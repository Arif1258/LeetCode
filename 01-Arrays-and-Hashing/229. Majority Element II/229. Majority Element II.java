1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int n = nums.length;
4        HashMap<Integer,Integer> map = new HashMap<>();
5        List<Integer> list = new ArrayList<>();
6
7        for(int num : nums){
8            map.put(num, map.getOrDefault(num,0)+1);   
9        }
10        for(int num : map.keySet()){
11            if(map.get(num) > n/3) list.add(num);
12        }
13
14        return list;
15    }
16}