class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        Deque<Integer> q = new ArrayDeque<>();
        int ans = 0, cnt = 0;
        for (int v : nums) {
            if (v <= right) {
                q.add(v);
                if (v >= left) {
                    cnt = q.size();
                }
                ans += cnt;
            } else {
                q.clear();
                cnt = 0;
            }
        }
        return ans;
    }
}
