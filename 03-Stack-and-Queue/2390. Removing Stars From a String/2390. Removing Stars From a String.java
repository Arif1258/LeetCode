1class Solution {
2    public String removeStars(String s) {
3        StringBuilder sb = new StringBuilder();
4        for(char ch : s.toCharArray()){
5            if(ch == '*'){
6                sb.deleteCharAt(sb.length() - 1);
7            }else{
8                sb.append(ch);
9            }
10        }
11        return sb.toString();
12    }
13}