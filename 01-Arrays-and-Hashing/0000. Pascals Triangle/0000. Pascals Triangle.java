1class Solution {
2    public List<List<Integer>> generate(int numRows) {
3        List<List<Integer>> ans = new ArrayList<>();
4
5        for(int i=0;i<numRows;i++){
6            List<Integer> list = new ArrayList<>();
7            list.add(1);
8
9            for(int j=1; j<i;j++){
10                list.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
11            }
12            if(i>0) list.add(1);
13
14            ans.add(list);
15        }
16        return ans;
17    }
18}