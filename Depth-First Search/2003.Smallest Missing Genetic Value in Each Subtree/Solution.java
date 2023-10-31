class Solution {

    Map<Integer, List<Integer>> g;
    Set<Integer> vis;

    public void dfs(int x, int[] nums) {
        vis.add(nums[x]);
        for (int v : g.getOrDefault(x, new ArrayList<>())) {
            if (!vis.contains(nums[v])) {
                dfs(v, nums);
            }
        }
    }

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        g = new HashMap<>();
        vis = new HashSet<>();

        int n = parents.length;
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int node = n, mi = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            if (nums[i] < mi) {
                mi = nums[i];
                node = i;
            }
        }
        int cur = 1;
        while (node != -1) {
            dfs(node, nums);
            while (vis.contains(cur)) {
                cur++;
            }
            ans[node] = cur;
            node = parents[node];
        }
        return ans;
    }
}