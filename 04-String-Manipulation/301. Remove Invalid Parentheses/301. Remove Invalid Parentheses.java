1class Solution {
2    public List<String> removeInvalidParentheses(String s) {
3        List<String> result = new ArrayList<>();
4        Queue<String> queue = new LinkedList<>();
5        Set<String> visited = new HashSet<>();
6
7        queue.offer(s);
8        visited.add(s);
9
10        boolean found = false;
11
12        while (!queue.isEmpty()) {
13            int size = queue.size();
14
15            for (int i = 0; i < size; i++) {
16                String current = queue.poll();
17
18                if (isValid(current)) {
19                    result.add(current);
20                    found = true;
21                }
22
23                // Once valid strings are found at this level,
24                // don't generate strings with more removals.
25                if (found) {
26                    continue;
27                }
28
29                for (int j = 0; j < current.length(); j++) {
30                    // Only remove parentheses.
31                    if (current.charAt(j) != '(' && current.charAt(j) != ')') {
32                        continue;
33                    }
34
35                    String next = current.substring(0, j)
36                            + current.substring(j + 1);
37
38                    if (visited.add(next)) {
39                        queue.offer(next);
40                    }
41                }
42            }
43
44            if (found) {
45                break;
46            }
47        }
48
49        return result;
50    }
51
52    private boolean isValid(String s) {
53        int balance = 0;
54
55        for (char ch : s.toCharArray()) {
56            if (ch == '(') {
57                balance++;
58            } else if (ch == ')') {
59                balance--;
60
61                if (balance < 0) {
62                    return false;
63                }
64            }
65        }
66
67        return balance == 0;
68    }
69}