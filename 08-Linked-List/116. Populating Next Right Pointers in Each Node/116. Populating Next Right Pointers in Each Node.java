1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node left;
6    public Node right;
7    public Node next;
8
9    public Node() {}
10    
11    public Node(int _val) {
12        val = _val;
13    }
14
15    public Node(int _val, Node _left, Node _right, Node _next) {
16        val = _val;
17        left = _left;
18        right = _right;
19        next = _next;
20    }
21};
22*/
23
24class Solution {
25    public Node connect(Node root) {
26        if(root == null) return null;
27
28        if(root.left != null || root.right != null){
29            root.left.next = root.right;
30            if(root.next != null){
31                root.right.next = root.next.left;
32            }
33        }
34        connect(root.left);
35        connect(root.right);
36        return root;
37    }
38}