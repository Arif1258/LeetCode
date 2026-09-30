1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int low = 1;
4        int high = 0;
5
6        for (int pile : piles) {
7            high = Math.max(high, pile);
8        }
9
10        int answer = high;
11
12        while (low <= high) {
13            int mid = low + (high - low) / 2;
14
15            if (canFinish(piles, h, mid)) {
16                answer = mid;
17                high = mid - 1;
18            } else {
19                low = mid + 1;
20            }
21        }
22
23        return answer;
24    }
25
26    private boolean canFinish(int[] piles, int h, int speed) {
27        long hours = 0;
28
29        for (int pile : piles) {
30            hours += (pile + speed - 1) / speed;
31
32            if (hours > h) {
33                return false;
34            }
35        }
36
37        return true;
38    }
39}