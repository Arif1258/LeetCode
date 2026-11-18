1class Solution {
2
3    static final int MOD = 1_000_000_007;
4
5    public int[] pse(int[] arr) {
6
7        int n = arr.length;
8        int[] ans = new int[n];
9
10        Stack<Integer> st = new Stack<>();
11
12        for (int i = 0; i < n; i++) {
13
14            while (!st.isEmpty() &&
15                   arr[st.peek()] >= arr[i]) {
16                st.pop();
17            }
18
19            ans[i] = st.isEmpty() ? -1 : st.peek();
20
21            st.push(i);
22        }
23
24        return ans;
25    }
26
27    public int[] nse(int[] arr) {
28
29        int n = arr.length;
30        int[] ans = new int[n];
31
32        Stack<Integer> st = new Stack<>();
33
34        for (int i = n - 1; i >= 0; i--) {
35
36            while (!st.isEmpty() &&
37                   arr[st.peek()] > arr[i]) {
38                st.pop();
39            }
40
41            ans[i] = st.isEmpty() ? n : st.peek();
42
43            st.push(i);
44        }
45
46        return ans;
47    }
48
49    public int sumSubarrayMins(int[] arr) {
50
51        int n = arr.length;
52
53        int[] prev = pse(arr);
54        int[] next = nse(arr);
55
56        long sum = 0;
57
58        for (int i = 0; i < n; i++) {
59
60            long left = i - prev[i];
61            long right = next[i] - i;
62
63            long contribution =
64                (arr[i] * left % MOD) * right % MOD;
65
66            sum = (sum + contribution) % MOD;
67        }
68
69        return (int) sum;
70    }
71}
72