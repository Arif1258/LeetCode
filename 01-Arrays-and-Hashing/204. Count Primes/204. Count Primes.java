1class Solution {
2    public int countPrimes(int n) {
3        if (n <= 2) {
4            return 0;
5        }
6        boolean[] isPrime = new boolean[n];
7        Arrays.fill(isPrime, true);
8
9        isPrime[0] = false;
10        isPrime[1] = false;
11
12        for (int i = 2; i * i < n; i++) {
13            if (isPrime[i]) {
14                for (int j = i * i; j < n; j += i) {
15                    isPrime[j] = false;
16                }
17            }
18        }
19
20        int count = 0;
21
22        for (int i = 2; i < n; i++) {
23            if (isPrime[i]) {
24                count++;
25            }
26        }
27
28        return count;
29    }
30}