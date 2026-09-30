1import java.util.Arrays;
2
3class Solution {
4    public int maxDistance(int[] position, int m) {
5        Arrays.sort(position);
6
7        int low = 1;
8        int high = position[position.length - 1] - position[0];
9        int answer = 0;
10
11        while (low <= high) {
12            int mid = low + (high - low) / 2;
13
14            if (canPlace(position, m, mid)) {
15                answer = mid;
16                low = mid + 1;
17            } else {
18                high = mid - 1;
19            }
20        }
21
22        return answer;
23    }
24
25    private boolean canPlace(int[] position, int m, int distance) {
26        int balls = 1;
27        int lastPosition = position[0];
28
29        for (int i = 1; i < position.length; i++) {
30            if (position[i] - lastPosition >= distance) {
31                balls++;
32                lastPosition = position[i];
33
34                if (balls == m) {
35                    return true;
36                }
37            }
38        }
39
40        return false;
41    }
42}