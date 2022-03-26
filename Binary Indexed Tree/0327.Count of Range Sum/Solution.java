class Solution {
    long[] tree;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        TreeSet<Long> ts = new TreeSet<>();
        for (long s : pre) {
            ts.add(s);
            ts.add(s - upper);
            ts.add(s - lower);
        }
        Map<Long, Integer> mp = new HashMap<>();
        int idx = 1;
        for (long s : ts) {
            mp.put(s, idx++);
        }
        tree = new long[mp.size() + 1];
        int ans = 0;
        for (long s : pre) {
            int l = mp.get(s - upper) - 1;
            int r = mp.get(s - lower);
            ans += query(r) - query(l);
            add(mp.get(s), 1);
        }
        return ans;
    }

    public int lowbit(int x) {
        return x & -x;
    }

    public int query(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

    public void add(int x, int incr) {
        while (x < tree.length) {
            tree[x] += incr;
            x += lowbit(x);
        }
    }
}