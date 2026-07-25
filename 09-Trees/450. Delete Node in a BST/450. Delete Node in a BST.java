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
17    public TreeNode deleteNode(TreeNode root, int key) {
18        if(root == null) return null;
19        if(root.val > key){
20            root.left = deleteNode(root.left,key);
21        }else if(root.val < key){
22            root.right = deleteNode(root.right,key);
23        }else{
24            if(root.left == null && root.right == null){
25                return null;
26            }
27            if(root.left == null){
28                return root.right;
29            }
30            if(root.right == null){
31                return root.left;
32            }
33            TreeNode IS = findInorderSuccessor(root.right);
34            root.val = IS.val;
35            root.right = deleteNode(root.right,IS.val);
36        }
37        return root;
38    }
39    public static TreeNode findInorderSuccessor(TreeNode root){
40        while(root.left != null){
41            root = root.left;
42        }
43        return root;
44    }
45}