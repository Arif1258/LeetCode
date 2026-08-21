1class Solution {
2    public String removeOuterParentheses(String s) {
3        StringBuilder ans = new StringBuilder();
4
5        int depth = 0;
6        for(char c: s.toCharArray()){
7            if(c == '('){
8                depth++;
9                if(depth > 1){
10                    ans.append(c);
11                }
12            }else{
13                depth--;
14                if(depth > 0){
15                    ans.append(c);
16                }
17            }
18        }
19        return ans.toString();
20    }
21}