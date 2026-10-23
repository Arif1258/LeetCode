1class Solution {
2    public int longestConsecutive(int[] nums) {
3        int n = nums.length;
4        HashSet<Integer> set = new HashSet<>();
5
6        for(int num : nums){
7            set.add(num);
8        }
9        int longest = 0;
10        for(int num : set){
11            if(!set.contains(num-1)){
12                int current = num;
13                int length = 1;
14                while(set.contains(current+1)){
15                    current++;
16                    length++;
17                }
18                longest = Math.max(longest, length);
19
20            }
21        }
22        return longest;
23            
24    }
25}