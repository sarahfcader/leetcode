/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int tiltSum = 0;

    public int findTilt(TreeNode root) {
        sumTree(root);
        return tiltSum;
    }

    public int sumTree(TreeNode node) {
        if (node == null) {
            return 0;
        } 
        
        int leftSum = sumTree(node.left);
        int rightSum = sumTree(node.right);

        tiltSum += Math.abs(leftSum - rightSum);
        return node.val + leftSum + rightSum;
    }
} 