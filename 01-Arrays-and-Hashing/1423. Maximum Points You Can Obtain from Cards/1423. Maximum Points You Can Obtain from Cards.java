1class Solution {
2    public int maxScore(int[] cardPoints, int k) {
3
4        int n = cardPoints.length;
5        int leftSum = 0;
6        int rightSum = 0;
7        int max = 0;
8        
9        for (int i = 0; i < k; i++) {
10            leftSum += cardPoints[i];
11        }
12
13        max = leftSum;
14        for (int i = 1; i <= k; i++) {
15            leftSum -= cardPoints[k - i];
16            rightSum += cardPoints[n - i];
17
18            max = Math.max(max, leftSum + rightSum);
19        }
20
21        return max;
22    }
23}