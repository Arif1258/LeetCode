1class Solution {
2    public String removeKdigits(String num, int k) {
3
4        Stack<Character> st = new Stack<>();
5        for (int i = 0; i < num.length(); i++) {
6            while (!st.isEmpty() && k > 0 &&
7                   (st.peek() - '0') > (num.charAt(i) - '0')) {
8
9                st.pop();
10                k--;
11            }
12
13            st.push(num.charAt(i));
14        }
15        while (k > 0) {
16            st.pop();
17            k--;
18        }
19
20        StringBuilder res = new StringBuilder();
21        while (!st.isEmpty()) {
22            res.append(st.pop());
23        }
24
25        res.reverse();
26        int i = 0;
27        while (i < res.length() && res.charAt(i) == '0') {
28            i++;
29        }
30
31        if (i == res.length()) {
32            return 0;
33        }
34
35        return res.substring(i);
36    }
37}
38