class Solution {

    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        p[find(a)] = find(b);
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int M = 100010, n = nums.length;
        if (n == 1) {
            return true;
        }
        p = new int[M];
        for (int i = 0; i < M; i++) {
            p[i] = i;
        }
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (v == 1) {
                return false;
            }
            if (s.contains(v)) {
                continue;
            }
            s.add(v);
            for (int j = 2; j * j <= v; j++) {
                if (v % j != 0) {
                    continue;
                }
                union(nums[i], j);
                while (v % j == 0) {
                    v /= j;
                }
            }
            if (v > 1 && nums[i] != v) {
                union(nums[i], v);
            }
        }
        int root = find(nums[0]);
        for (int v : nums) {
            if (find(v) != root) {
                return false;
            }
        }
        return true;
    }
}