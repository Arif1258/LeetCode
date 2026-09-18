1class Solution {
2    public List<Integer> findSubstring(String s, String[] words) {
3
4        List<Integer> result = new ArrayList<>();
5
6        if (s == null || words == null || words.length == 0) {
7            return result;
8        }
9
10        int wordLength = words[0].length();
11        int wordCount = words.length;
12        int totalLength = wordLength * wordCount;
13
14        if (s.length() < totalLength) {
15            return result;
16        }
17        Map<String, Integer> required = new HashMap<>();
18
19        for (String word : words) {
20            required.put(word, required.getOrDefault(word, 0) + 1);
21        }
22        for (int offset = 0; offset < wordLength; offset++) {
23
24            int left = offset;
25            int right = offset;
26            int count = 0;
27
28            Map<String, Integer> current = new HashMap<>();
29
30            while (right + wordLength <= s.length()) {
31
32                String word = s.substring(right, right + wordLength);
33                right += wordLength;
34                if (!required.containsKey(word)) {
35                    current.clear();
36                    count = 0;
37                    left = right;
38                    continue;
39                }
40
41                current.put(word, current.getOrDefault(word, 0) + 1);
42                count++;
43                while (current.get(word) > required.get(word)) {
44
45                    String leftWord =
46                        s.substring(left, left + wordLength);
47
48                    current.put(
49                        leftWord,
50                        current.get(leftWord) - 1
51                    );
52
53                    left += wordLength;
54                    count--;
55                }
56                if (count == wordCount) {
57                    result.add(left);
58                    String leftWord =
59                        s.substring(left, left + wordLength);
60
61                    current.put(
62                        leftWord,
63                        current.get(leftWord) - 1
64                    );
65
66                    left += wordLength;
67                    count--;
68                }
69            }
70        }
71
72        return result;
73    }
74}