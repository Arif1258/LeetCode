1class Solution {
2    public String evaluate(String s, List<List<String>> knowledge) {
3        HashMap<String, String> map = new HashMap<>();
4        for (List<String> pair : knowledge) {
5            map.put(pair.get(0), pair.get(1));
6        }
7        StringBuilder result = new StringBuilder();
8        int i = 0;
9        while (i < s.length()) {
10            if (s.charAt(i) == '(') {
11                int j = i + 1;
12
13                while (s.charAt(j) != ')') {
14                    j++;
15                }
16                String key = s.substring(i + 1, j);
17                if (map.containsKey(key)) {
18                    result.append(map.get(key));
19                } else {
20                    result.append('?');
21                }
22                i = j + 1;
23            } else {
24                result.append(s.charAt(i));
25                i++;
26            }
27        }
28
29        return result.toString();
30    }
31}