class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int mx = 0;
        for (int v : nums1) {
            if (v % k != 0) {
                continue;
            }
            cnt.put(v / k, cnt.getOrDefault(v / k, 0) + 1);
            mx = Math.max(mx, v);
        }
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int v : nums2) {
            cnt2.put(v, cnt2.getOrDefault(v, 0) + 1);
        }
        long ans = 0;
        for (Integer x : cnt2.keySet()) {
            for (int y = x; y <= mx; y += x) {
                ans += (long)cnt.getOrDefault(y, 0) * cnt2.get(x);
            }
        }
        return ans;
    }
}