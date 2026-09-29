1class Solution {
2    public List<Integer> partitionLabels(String s) {
3        List<Integer> ans = new ArrayList<>();
4        int last [] = new int [26];
5
6        for(int i=0; i<s.length(); i++){
7            last[s.charAt(i) - 'a'] = i;
8        }
9
10        int start = 0;
11        int end = 0;
12
13        for(int i=0; i<s.length();i++){
14            end = Math.max(end, last[s.charAt(i) - 'a']);
15            if(end == i){
16                ans.add(end - start + 1);
17                start = i+1;
18            }
19        }
20        return ans;
21    }
22}