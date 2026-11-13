1class Solution {
2
3    int diameter = 0;
4    public int diameterOfBinaryTree(TreeNode root) {
5        height(root);
6        return diameter;
7    }
8
9    public int height(TreeNode root) {
10        if (root == null) return 0;
11
12        int leftHT = height(root.left);
13        int rightHT = height(root.right);
14        diameter = Math.max(diameter, leftHT + rightHT);
15
16        return 1 + Math.max(leftHT, rightHT);
17    }
18}