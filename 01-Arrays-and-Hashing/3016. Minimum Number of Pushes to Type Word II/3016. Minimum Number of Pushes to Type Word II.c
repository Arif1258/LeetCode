1class Solution {
2    public int minimumPushes(String word) {
3        int[] freq = new int[26];
4        for (char ch : word.toCharArray()) {
5            freq[ch - 'a']++;
6        }
7        Arrays.sort(freq);
8        int ans = 0;
9        int index = 0;
10        for (int i = 25; i >= 0; i--) {
11
12            if (freq[i] == 0) break;
13
14            ans += freq[i] * (index / 8 + 1);
15            index++;
16        }
17        return ans;
18    }
19}