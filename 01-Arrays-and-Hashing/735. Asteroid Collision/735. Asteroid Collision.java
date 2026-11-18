1class Solution {
2    public int[] asteroidCollision(int[] asteroids) {
3
4        List<Integer> list = new ArrayList<>();
5
6        for (int i = 0; i < asteroids.length; i++) {
7
8            if (asteroids[i] > 0) {
9                list.add(asteroids[i]);
10            }
11            else {
12                while (!list.isEmpty() &&
13                       list.get(list.size() - 1) > 0 &&
14                       list.get(list.size() - 1) < Math.abs(asteroids[i])) {
15
16                    list.remove(list.size() - 1);
17                }
18
19                if (!list.isEmpty() &&
20                    list.get(list.size() - 1) == Math.abs(asteroids[i])) {
21
22                    list.remove(list.size() - 1);
23                }
24                else if (list.isEmpty() ||
25                         list.get(list.size() - 1) < 0) {
26
27                    list.add(asteroids[i]);
28                }
29            }
30        }
31
32        int[] ans = new int[list.size()];
33
34        for (int i = 0; i < list.size(); i++) {
35            ans[i] = list.get(i);
36        }
37
38        return ans;
39    }
40}
41