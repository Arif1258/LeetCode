1
2class Solution {
3    public boolean checkString(String s) {
4        boolean foundB = false;
5
6        for (char ch : s.toCharArray()) {
7            if (ch == 'b') {
8                foundB = true;
9            } else if (foundB) {
10                return false;
11            }
12        }
13
14        return true;
15    }
16}
17