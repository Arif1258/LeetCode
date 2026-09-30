1class Solution {
2    public String makeGood(String s) {
3        Stack<Character> sq = new Stack<>();
4
5        for(int i=0; i<s.length();i++){
6            char ch = s.charAt(i);
7
8            if(!sq.isEmpty() && Math.abs(sq.peek() - ch) == 32){
9                sq.pop();
10            }else{
11                sq.push(ch);
12            }
13
14        }
15        StringBuilder sb = new StringBuilder();
16        while(!sq.isEmpty()){
17            sb.append(sq.pop());
18        }
19        return sb.reverse().toString();
20    }
21}