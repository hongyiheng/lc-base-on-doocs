class Solution {

    Map<Integer, List<Integer>> g = new HashMap<>(), f = new HashMap<>();
    Map<Integer, Deque<int[]>> stks = new HashMap<>();
    int[] ans;
    int[] nums;

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public void dfs(int u, int p, int d) {
        int t = -1, dd = -1;
        for (int v : f.getOrDefault(nums[u], new ArrayList<>())) {
            Deque<int[]> stk = stks.getOrDefault(v, new ArrayDeque<>());
            if (!stk.isEmpty() && stk.peekLast()[1] > dd) {
                t = stk.peekLast()[0];
                dd = stk.peekLast()[1];
            }
        }
        ans[u] = t;
        stks.computeIfAbsent(nums[u], k -> new ArrayDeque<>()).add(new int[]{u, d});
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            dfs(v, u, d + 1);
        }
        stks.get(nums[u]).pollLast();
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        this.nums = nums;
        ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 51; i++) {
            for (int j = i; j < 51; j++) {
                if (gcd(i, j) != 1) {
                    continue;
                }
                f.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                f.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        dfs(0, -1, 0);
        return ans;
    }
}