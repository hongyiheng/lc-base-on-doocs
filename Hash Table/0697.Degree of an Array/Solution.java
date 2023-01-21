class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        int mx = 0;
        Set<Integer> s = new HashSet<>();
        for (var e : mp.entrySet()) {
            if (e.getValue() > mx) {
                mx = e.getValue();
                s.clear();
            }
            if (e.getValue() == mx) {
                s.add(e.getKey());
            }
        }
        Map<Integer, int[]> idxs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                int[] idx = idxs.getOrDefault(nums[i], new int[]{0x3f3f3f, 0});
                idx[0] = Math.min(idx[0], i);
                idx[1] = Math.max(idx[1], i);
                idxs.put(nums[i], idx);
            }
        }
        int ans = 0x3f3f3f;
        for (int[] idx : idxs.values()) {
            ans = Math.min(ans, idx[1] - idx[0] + 1);
        }
        return ans;
    }
}