1class Solution {
2    public boolean checkValidString(String s) {
3        int low = 0;   
4        int high = 0;  
5
6        for (char c : s.toCharArray()) {
7
8            if (c == '(') {
9                low++;
10                high++;
11            }
12
13            else if (c == ')') {
14                low--;
15                high--;
16            }
17
18            else { // '*'
19                low--;  
20                high++;  
21            }
22            if (high < 0) {
23                return false;
24            }
25            low = Math.max(low, 0);
26        }
27
28        return low == 0;
29    }
30}