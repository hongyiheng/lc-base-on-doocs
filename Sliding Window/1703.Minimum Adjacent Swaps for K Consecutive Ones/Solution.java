class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pos.add(i);
            }
        }
        int cur = 0;
        for (int i = 1; i < k; i++) {
            cur += (pos.get(i) - pos.get(i - 1) - 1) * Math.min(i, k - i);
        }
        int ans = cur, mid = k / 2;
        for (int r = k; r < pos.size(); r++) {
            cur -= pos.get(r - k + mid) - pos.get(r - k);
            cur += pos.get(r) - pos.get(r - mid);
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
