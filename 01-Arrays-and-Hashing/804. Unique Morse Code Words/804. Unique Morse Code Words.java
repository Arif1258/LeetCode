1class Solution {
2    public int uniqueMorseRepresentations(String[] words) {
3        String[] morse = {
4            .-, -..., -.-., -.., ., ..-., --., ....,
5            .., .---, -.-, .-.., --, -., ---, .--.,
6            --.-, .-., ..., -, ..-, ...-, .--, -..-,
7            -.--, --..
8        };
9        Set<String> set = new HashSet<>();
10        for (String word : words) {
11            StringBuilder sb = new StringBuilder();
12            for (char ch : word.toCharArray()) {
13                sb.append(morse[ch - 'a']);
14            }
15            set.add(sb.toString());
16        }
17        return set.size();
18    }
19}