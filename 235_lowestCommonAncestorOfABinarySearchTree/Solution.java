/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // First, search down to one of the nodes, recording its ancestors along the way.
        // Then do the same for the other. The LCA is the last node found in both ancestors of p and q.

        List<TreeNode> ancestorsP = new ArrayList<>();
        TreeNode LCA = root;
        TreeNode cursor = root;

        // First search for p and get all its ancestors.
        ancestorsP.add(p);
        while (cursor != p) {
            ancestorsP.add(cursor);
            cursor = (p.val < cursor.val) ? cursor.left : cursor.right;
        }

        // Now search for q.
        cursor = root;
        while (!(cursor == q.left || cursor == q.right)) {
            if (ancestorsP.contains(cursor)) {
                LCA = cursor;
            }
            cursor = (q.val < cursor.val) ? cursor.left : cursor.right;
        }

        return LCA;
    }
}