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
17    public List<String> binaryTreePaths(TreeNode root) {
18        List<String> ans = new ArrayList<>();
19
20        dfs(root, , ans);
21
22        return ans;
23    }
24    private void dfs(TreeNode node, String path, List<String> ans) {
25        if (node == null) {
26            return;
27        }
28        path += node.val;
29        if (node.left == null && node.right == null) {
30            ans.add(path);
31            return;
32        }
33        path += ->;
34        dfs(node.left, path, ans);
35        dfs(node.right, path, ans);
36    }
37}