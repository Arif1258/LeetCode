1class MinStack {
2
3    Stack<Long> st;
4    long min;
5
6    public MinStack() {
7        st = new Stack<>();
8    }
9
10    public void push(int val) {
11
12        if (st.isEmpty()) {
13            st.push((long) val);
14            min = val;
15        }
16
17        else if (val < min) {
18            st.push(2L * val - min);
19            min = val;
20        }
21
22        else {
23            st.push((long) val);
24        }
25    }
26
27    public void pop() {
28
29        long x = st.pop();
30
31        if (x < min) {
32            min = 2 * min - x;
33        }
34    }
35
36    public int top() {
37
38        long x = st.peek();
39
40        if (x < min) {
41            return (int) min;
42        }
43
44        return (int) x;
45    }
46
47    public int getMin() {
48        return (int) min;
49    }
50}
51