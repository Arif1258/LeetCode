1class Solution {
2    public int minSwaps(int[] nums) {
3        int n = nums.length;
4        int[][] arr = new int[n][2];
5
6        for (int i = 0; i < n; i++) {
7            arr[i][0] = nums[i];
8            arr[i][1] = digitSum(nums[i]);
9        }
10
11        Arrays.sort(arr, (a, b) -> {
12            if (a[1] != b[1]) {
13                return Integer.compare(a[1], b[1]);
14            }
15            return Integer.compare(a[0], b[0]);
16        });
17
18        Map<Integer, Integer> originalIndex = new HashMap<>();
19        for (int i = 0; i < n; i++) {
20            originalIndex.put(nums[i], i);
21        }
22
23        int swaps = 0;
24        for (int i = 0; i < n; i++) {
25            int correctIndex = originalIndex.get(arr[i][0]);
26            if (correctIndex != i) {
27                int otherValue = nums[i];
28
29                nums[i] = nums[correctIndex];
30                nums[correctIndex] = otherValue;
31
32                originalIndex.put(nums[correctIndex], correctIndex);
33                originalIndex.put(nums[i], i);
34                swaps++;
35            }
36        }
37
38        return swaps;
39    }
40
41    private int digitSum(int num) {
42        int sum = 0;
43        while (num > 0) {
44            sum += num % 10;
45            num /= 10;
46        }
47        return sum;
48    }
49}
50