class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    public void dfs(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        for (Node item : root.children) {
            dfs(res, item);
        }
        res.add(root.val);
    }
}