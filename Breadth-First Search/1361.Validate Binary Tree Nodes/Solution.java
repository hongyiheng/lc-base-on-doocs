class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (vis[leftChild[i]]) {
                    return false;
                }
                vis[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                if (vis[rightChild[i]]) {
                    return false;
                }
                vis[rightChild[i]] = true;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                q.add(i);
            }
        }
        if (q.size() != 1) {
            return false;
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int cur = q.pollFirst();
                cnt++;
                if (leftChild[cur] != -1) {
                    q.addLast(leftChild[cur]);
                }
                if (rightChild[cur] != -1) {
                    q.addLast(rightChild[cur]);
                }
            }
        }
        return cnt == n;
    }
}
