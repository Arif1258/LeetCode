1class Solution {
2    private String s;
3    private int index;
4
5    public List<String> braceExpansionII(String expression) {
6        s = expression;
7        index = 0;
8
9        Set<String> result = parseExpression();
10
11        List<String> answer = new ArrayList<>(result);
12        Collections.sort(answer);
13
14        return answer;
15    }
16    private Set<String> parseExpression() {
17        Set<String> result = parseTerm();
18
19        while (index < s.length() && s.charAt(index) == ',') {
20            index++; // skip ','
21
22            Set<String> next = parseTerm();
23            result.addAll(next);
24        }
25
26        return result;
27    }
28    private Set<String> parseTerm() {
29        Set<String> result = new HashSet<>();
30        result.add();
31
32        while (index < s.length()
33                && s.charAt(index) != '}'
34                && s.charAt(index) != ',') {
35
36            Set<String> next;
37
38            if (s.charAt(index) == '{') {
39                index++; // skip '{'
40
41                next = parseExpression();
42
43                index++; // skip '}'
44            } else {
45                next = new HashSet<>();
46                next.add(String.valueOf(s.charAt(index)));
47                index++;
48            }
49
50            result = combine(result, next);
51        }
52
53        return result;
54    }
55    private Set<String> combine(Set<String> first, Set<String> second) {
56        Set<String> result = new HashSet<>();
57
58        for (String a : first) {
59            for (String b : second) {
60                result.add(a + b);
61            }
62        }
63
64        return result;
65    }
66}