class Solution {
    Map<Integer, List<Integer>> mp;
    int[] cnt;
    int n, ans;
    long mx;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        mp = new HashMap<>();
        cnt = new int[n];
        Arrays.fill(cnt, -1);
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                continue;
            }
            mp.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }
        dfs(0);
        return ans;
    }

    public int dfs(int index) {
        int left = 0, right = 0;
        List<Integer> children = mp.getOrDefault(index, new ArrayList<>());
        if (children.size() > 0) {
            left = cnt[children.get(0)] != -1 ? cnt[children.get(0)] : dfs(children.get(0));
        }
        if (children.size() > 1) {
            right = cnt[children.get(1)] != -1 ? cnt[children.get(1)] : dfs(children.get(1));
        }
        long source = Math.max(1, left) * Math.max(1, right) * (long) Math.max(1, n - 1 - left - right);
        if (source > mx) {
            mx = source;
            ans = 1;
        } else if (source == mx) {
            ans++;
        }
        cnt[index] = left + right + 1;
        return cnt[index];
    }
}