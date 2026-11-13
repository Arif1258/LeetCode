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
16class Solution {
17    public boolean isSymmetric(TreeNode root) {
18        if (root == null) return true;
19        return mirror(root.left, root.right);
20    }
21
22    private boolean mirror(TreeNode left, TreeNode right) {
23        if(left == null || right == null) return left == right;
24
25        if(left.val != right.val) return false;
26
27        return mirror(left.left, right.right) && mirror(left.right, right.left);
28    }
29}