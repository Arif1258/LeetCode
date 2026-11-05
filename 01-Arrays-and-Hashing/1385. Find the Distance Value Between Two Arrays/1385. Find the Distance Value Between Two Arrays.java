1class Solution {
2    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
3        int count = 0;
4
5        for (int num1 : arr1) {
6            boolean valid = true;
7
8            for (int num2 : arr2) {
9                if (Math.abs(num1 - num2) <= d) {
10                    valid = false;
11                    break;
12                }
13            }
14
15            if (valid) {
16                count++;
17            }
18        }
19
20        return count;
21    }
22}