1class Solution {
2    public String minRemoveToMakeValid(String s) {
3        Stack<Integer> stack = new Stack<>();
4        boolean removed [] = new boolean[s.length()];
5
6        for(int i=0; i<s.length();i++){
7            char ch = s.charAt(i);
8
9            if(ch == '('){
10                stack.push(i);
11            }else if(ch == ')'){
12                if(!stack.isEmpty()){
13                    stack.pop();
14                }else{
15                    removed[i] = true;
16            }   }
17        }
18        while(!stack.isEmpty()){
19            removed[stack.pop()] = true;
20        }
21        StringBuilder ans = new StringBuilder();
22
23        for(int i=0; i<s.length();i++){
24            if(!removed[i]){
25                ans.append(s.charAt(i));
26            }
27        }
28        return ans.toString();
29    }
30}