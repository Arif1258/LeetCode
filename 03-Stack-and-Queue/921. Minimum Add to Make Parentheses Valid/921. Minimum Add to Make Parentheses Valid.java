1class Solution {
2    public int minAddToMakeValid(String s) {
3        int bal = 0;
4        int extra = 0;
5
6        for(char ch : s.toCharArray()){
7            if(ch == '('){
8                bal++;
9            }else if(ch == ')'){
10                if(bal > 0) bal--;
11                else extra++;
12            }
13        }
14        return extra+bal;
15    }
16}