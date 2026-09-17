1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4        int[] best = new int[n];
5
6        int INF = n + 1;
7        int minLength = INF;
8
9        // prefixSum -> latest index
10        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
11        map.put(0, -1);
12
13        int prefixSum = 0;
14
15        for (int right = 0; right < n; right++) {
16            prefixSum += arr[right];
17
18            best[right] = right > 0 ? best[right - 1] : INF;
19
20            if (map.containsKey(prefixSum - target)) {
21                int left = map.get(prefixSum - target);
22                int currentLength = right - left;
23
24                // A previous non-overlapping subarray must end before left
25                if (left >= 0 && best[left] != INF) {
26                    minLength = Math.min(
27                        minLength,
28                        currentLength + best[left]
29                    );
30                }
31
32                best[right] = Math.min(best[right], currentLength);
33            }
34
35            map.put(prefixSum, right);
36        }
37
38        return minLength == INF ? -1 : minLength;
39    }
40}