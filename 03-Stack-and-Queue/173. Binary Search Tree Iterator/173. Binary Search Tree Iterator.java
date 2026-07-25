1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class BSTIterator {
17    Stack<TreeNode> s = new Stack<>();
18    void storeLeftNodes(TreeNode root){
19        while(root != null){
20            s.push(root);
21            root = root.left;
22        }
23    }
24
25    public BSTIterator(TreeNode root) {
26        storeLeftNodes(root);
27    }
28    
29    public int next() {
30        TreeNode ans = s.peek();
31        s.pop();
32        storeLeftNodes(ans.right);
33        return ans.val;
34    }
35    
36    public boolean hasNext() {
37        return s.size() > 0;
38    }
39}
40
41/**
42 * Your BSTIterator object will be instantiated and called as such:
43 * BSTIterator obj = new BSTIterator(root);
44 * int param_1 = obj.next();
45 * boolean param_2 = obj.hasNext();
46 */