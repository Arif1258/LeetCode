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
17    public TreeNode sortedArrayToBST(int[] nums) {
18        return created(nums,0,nums.length-1);
19         
20    }
21    public static TreeNode created(int []nums,int st,int end){
22        if(st>end) return null;
23        int mid = (st+end)/2;
24        TreeNode root = new TreeNode(nums[mid]);
25        root.left = created(nums,st,mid-1);
26        root.right = created(nums,mid+1,end);
27        return root;
28    }
29}