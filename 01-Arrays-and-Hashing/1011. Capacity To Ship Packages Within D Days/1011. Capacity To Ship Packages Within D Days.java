1class Solution {
2    public int shipWithinDays(int[] weights, int days) {
3        int low = 0;
4        int high = 0;
5
6        for (int weight : weights) {
7            low = Math.max(low, weight);
8            high += weight;
9        }
10
11        int answer = high;
12
13        while (low <= high) {
14            int capacity = low + (high - low) / 2;
15
16            if (canShip(weights, days, capacity)) {
17                answer = capacity;
18                high = capacity - 1;
19            } else {
20                low = capacity + 1;
21            }
22        }
23
24        return answer;
25    }
26
27    private boolean canShip(int[] weights, int days, int capacity) {
28        int daysUsed = 1;
29        int currentWeight = 0;
30
31        for (int weight : weights) {
32            if (currentWeight + weight > capacity) {
33                daysUsed++;
34                currentWeight = weight;
35            } else {
36                currentWeight += weight;
37            }
38        }
39
40        return daysUsed <= days;
41    }
42}