class Solution {
    public int countArrangement(int n) {
        Set<List<Integer>> res = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, path, 0, new boolean[n], n);
        return res.size();
    }

    public void dfs(Set<List<Integer>> res, Deque<Integer> path, int depth, boolean[] used, int len) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            int num = i + 1;
            if (used[i] || (num % (path.size() + 1) != 0 && (path.size() + 1) % num != 0)) {
                continue;
            }
            path.addLast(num);
            used[i] = true;
            dfs(res, path, depth + 1, used, len);
            path.removeLast();
            used[i] = false;
        }
    }
}