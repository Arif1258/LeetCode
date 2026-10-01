1// class Solution {
2//     public int[] singleNumber(int[] nums) {
3//         HashMap<Integer, Integer> map = new HashMap<>();
4//         int ans [] = new int[2];
5//         int i=0;
6
7//         for(int num : nums){
8//             map.put(num, map.getOrDefault(num,0)+1);
9//         }
10
11//         for(int num : nums){
12//             if(map.get(num) != 2){
13//                 ans[i++] = num;
14//             }
15//         }
16//         return ans;
17        
18//     }
19// }
20
21class Solution {
22    public int[] singleNumber(int[] nums) {
23        int xor = 0;
24        for(int num : nums){
25            xor ^= num;
26        }
27        int a=0;
28        int b=0;
29        int bit = xor & - xor;
30
31        for(int num : nums){
32            if((num & bit) != 0){
33                a = a^num;
34            }else {
35                b = b^num;
36            }
37        }
38        return new int[] {a,b};
39        
40    }
41}