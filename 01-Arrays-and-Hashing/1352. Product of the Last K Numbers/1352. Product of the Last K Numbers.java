1
2import java.util.*;
3
4class ProductOfNumbers {
5
6    List<Integer> prefix;
7
8    public ProductOfNumbers() {
9        prefix = new ArrayList<>();
10        prefix.add(1);
11    }
12
13    public void add(int num) {
14
15        if (num == 0) {
16            prefix.clear();
17            prefix.add(1);
18        } else {
19            int last = prefix.get(prefix.size() - 1);
20            prefix.add(last * num);
21        }
22    }
23
24    public int getProduct(int k) {
25
26        int n = prefix.size();
27
28        if (k >= n) {
29            return 0;
30        }
31
32        return prefix.get(n - 1) / prefix.get(n - 1 - k);
33    }
34}
35