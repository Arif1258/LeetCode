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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> ans = new ArrayList<>();
19        if (root == null) return ans;
20        Queue<TreeNode> q = new LinkedList<>();
21        q.offer(root);
22        while (!q.isEmpty()) {
23            List<Integer> level = new ArrayList<>();
24            for (int i = q.size(); i > 0; i--) {
25                TreeNode node = q.poll();
26                level.add(node.val);
27
28                if (node.left != null) q.offer(node.left);
29                if (node.right != null) q.offer(node.right);
30            }
31            ans.add(level);
32        }
33        return ans;
34    }
35}