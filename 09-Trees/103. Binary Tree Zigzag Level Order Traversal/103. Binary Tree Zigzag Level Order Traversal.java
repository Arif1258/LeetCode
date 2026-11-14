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
16
17class Solution {
18    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
19        List<List<Integer>> result = new ArrayList<>();
20        if (root == null) return result;
21        Queue<TreeNode> queue = new LinkedList<>();
22        queue.offer(root);
23        boolean leftToRight = true;
24        while (!queue.isEmpty()) {
25            int size = queue.size();
26            List<Integer> level = new ArrayList<>();
27            for (int i = 0; i < size; i++) {
28                TreeNode node = queue.poll();
29                if (leftToRight) {
30                    level.add(node.val);
31                } else {
32                    level.add(0, node.val);
33                }
34
35                if (node.left != null) {
36                    queue.offer(node.left);
37                }
38
39                if (node.right != null) {
40                    queue.offer(node.right);
41                }
42            }
43
44            result.add(level);
45            leftToRight = !leftToRight;
46        }
47
48        return result;
49    }
50}
51