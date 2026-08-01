1class LRUCache {
2
3    class Node {
4        int key;
5        int value;
6        Node prev;
7        Node next;
8
9        Node(int key, int value) {
10            this.key = key;
11            this.value = value;
12        }
13    }
14
15    private HashMap<Integer, Node> map;
16    private int capacity;
17    private Node head;
18    private Node tail;
19
20    public LRUCache(int capacity) {
21        this.capacity = capacity;
22        map = new HashMap<>();
23
24        head = new Node(-1, -1);
25        tail = new Node(-1, -1);
26
27        head.next = tail;
28        tail.prev = head;
29    }
30
31    public int get(int key) {
32        if (!map.containsKey(key)) {
33            return -1;
34        }
35
36        Node node = map.get(key);
37        remove(node);
38        addFirst(node);
39
40        return node.value;
41    }
42
43    public void put(int key, int value) {
44
45        if (map.containsKey(key)) {
46            Node node = map.get(key);
47            node.value = value;
48            remove(node);
49            addFirst(node);
50            return;
51        }
52
53        if (map.size() == capacity) {
54            Node lru = tail.prev;
55            remove(lru);
56            map.remove(lru.key);
57        }
58
59        Node node = new Node(key, value);
60        addFirst(node);
61        map.put(key, node);
62    }
63
64    private void remove(Node node) {
65        node.prev.next = node.next;
66        node.next.prev = node.prev;
67    }
68
69    private void addFirst(Node node) {
70        node.next = head.next;
71        node.prev = head;
72
73        head.next.prev = node;
74        head.next = node;
75    }
76}
77
78/**
79 * Your LRUCache object will be instantiated and called as such:
80 * LRUCache obj = new LRUCache(capacity);
81 * int param_1 = obj.get(key);
82 * obj.put(key,value);
83 */