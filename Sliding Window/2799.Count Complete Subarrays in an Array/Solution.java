class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, ans = 0;
        int t = (int) Arrays.stream(nums).distinct().count();
        Map<Integer, Integer> g = new HashMap<>();
        while (r < n) {
            g.put(nums[r], g.getOrDefault(nums[r], 0) + 1);
            while (g.keySet().size() == t) {
                ans += n - r;
                int v = g.get(nums[l]);
                if (v == 1) {
                    g.remove(nums[l]);
                } else {
                    g.put(nums[l], v - 1);
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}