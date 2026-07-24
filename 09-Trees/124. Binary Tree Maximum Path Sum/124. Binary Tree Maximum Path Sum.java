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
17    int maxSum = Integer.MIN_VALUE;
18    public int maxPathSum(TreeNode root) {
19        dfs(root);
20        return maxSum;
21    }
22    private int dfs(TreeNode root) {
23        if (root == null) {
24            return 0;
25        }
26        int left = Math.max(0, dfs(root.left));
27        int right = Math.max(0, dfs(root.right));
28        maxSum = Math.max(maxSum, left + right + root.val);
29        return root.val + Math.max(left, right);
30    }
31}