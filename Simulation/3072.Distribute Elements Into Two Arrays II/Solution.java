class Solution {
    public int search(List<Integer> q, int x) {
        int l = 0, r = q.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (q.get(mid) <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public int[] resultArray(int[] nums) {
        List<Integer> res1 = new ArrayList<>(), res2 = new ArrayList<>(), q1 = new ArrayList<>(), q2 = new ArrayList<>();
        res1.add(nums[0]);
        q1.add(nums[0]);
        res2.add(nums[1]);
        q2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int v = nums[i];
            int idx1 = search(q1, v), idx2 = search(q2, v);
            int m = q1.size(), n = q2.size();
            if (m - idx1 == n - idx2) {
                if (m <= n) {
                    res1.add(v);
                    q1.add(idx1, v);
                } else {
                    res2.add(v);
                    q2.add(idx2, v);
                }
            } else if (m - idx1 > n - idx2) {
                res1.add(v);
                q1.add(idx1, v);
            } else {
                res2.add(v);
                q2.add(idx2, v);
            }
        }
        res1.addAll(res2);
        return res1.stream().mapToInt(e -> e).toArray();
    }
}