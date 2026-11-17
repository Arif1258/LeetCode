1class MyStack {
2
3    Queue<Integer> q = new LinkedList<>();
4
5    public MyStack() {
6    }
7
8    public void push(int x) {
9        q.offer(x);
10
11        int size = q.size();
12
13        for (int i = 0; i < size - 1; i++) {
14            q.offer(q.poll());
15        }
16    }
17
18    public int pop() {
19        return q.poll();
20    }
21
22    public int top() {
23        return q.peek();
24    }
25
26    public boolean empty() {
27        return q.isEmpty();
28    }
29}
30