1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
12        if(root == null || root == p || root == q){
13            return root;
14        }
15        TreeNode leftlca = lowestCommonAncestor(root.left,p,q);
16        TreeNode rightlca = lowestCommonAncestor(root.right,p,q);
17        if(leftlca == null) return rightlca;
18        if(rightlca == null) return leftlca;
19        return root;
20    }
21}