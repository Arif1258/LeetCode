1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3        long requiredFlowers = (long) m * k;
4
5        if (requiredFlowers > bloomDay.length) {
6            return -1;
7        }
8
9        int low = Integer.MAX_VALUE;
10        int high = Integer.MIN_VALUE;
11
12        for (int day : bloomDay) {
13            low = Math.min(low, day);
14            high = Math.max(high, day);
15        }
16
17        int answer = -1;
18
19        while (low <= high) {
20            int mid = low + (high - low) / 2;
21
22            if (canMakeBouquets(bloomDay, m, k, mid)) {
23                answer = mid;
24                high = mid - 1;
25            } else {
26                low = mid + 1;
27            }
28        }
29
30        return answer;
31    }
32
33    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
34        int flowers = 0;
35        int bouquets = 0;
36
37        for (int bloom : bloomDay) {
38            if (bloom <= day) {
39                flowers++;
40
41                if (flowers == k) {
42                    bouquets++;
43                    flowers = 0;
44                }
45            } else {
46                flowers = 0;
47            }
48
49            if (bouquets >= m) {
50                return true;
51            }
52        }
53
54        return false;
55    }
56}