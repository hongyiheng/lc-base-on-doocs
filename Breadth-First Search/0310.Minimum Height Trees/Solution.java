class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] step = new int[n];
        Map<Integer, List<Integer>> head = new HashMap<>();
        for (int[] e : edges) {
            step[e[0]]++;
            step[e[1]]++;
            head.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            head.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (step[i] == 1) {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            ans = new ArrayList<>();
            int m = q.size();
            while (m-- > 0) {
                int cur = q.pollFirst();
                ans.add(cur);
                List<Integer> next = head.get(cur);
                for (int node : next) {
                    step[node]--;
                    if (step[node] == 1) {
                        q.addLast(node);
                    }
                }
            }
        }
        return ans;
    }
}