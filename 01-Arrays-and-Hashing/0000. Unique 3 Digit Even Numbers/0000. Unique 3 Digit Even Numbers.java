1class Solution {
2    public int totalNumbers(int[] digits) {
3        Set<Integer> set = new HashSet<>();
4        for (int i = 0; i < digits.length; i++) {
5            for (int j = 0; j < digits.length; j++) {
6                for (int k = 0; k < digits.length; k++) {
7                    if (i == j || j == k || i == k) {
8                        continue;
9                    }
10                    if (digits[i] == 0) {
11                        continue;
12                    }
13                    if (digits[k] % 2 != 0) {
14                        continue;
15                    }
16                    int num = digits[i] * 100
17                            + digits[j] * 10
18                            + digits[k];
19
20                    set.add(num);
21                }
22            }
23        }
24
25        return set.size();
26    }
27}