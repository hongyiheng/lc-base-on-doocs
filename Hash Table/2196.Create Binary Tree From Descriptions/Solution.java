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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> child = new HashSet<>();
        for (int[] d : descriptions) {
            int pVal = d[0], cVal = d[1];
            boolean left = d[2] == 1;
            TreeNode p = mp.getOrDefault(pVal, new TreeNode(pVal));
            TreeNode c = mp.getOrDefault(cVal, new TreeNode(cVal));
            if (left) {
                p.left = c;
            } else {
                p.right = c;
            }
            mp.put(pVal, p);
            mp.put(cVal, c);
            child.add(cVal);
        }
        for (int v : mp.keySet()) {
            if (!child.contains(v)) {
                return mp.get(v);
            }
        }
        return null;
    }
}