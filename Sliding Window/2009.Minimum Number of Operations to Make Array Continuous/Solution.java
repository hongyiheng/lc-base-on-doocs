class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> g = new HashMap<>();
        int ans = 0, l = 0, cnt = 0, dup = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] - nums[l] >= n) {
                int c = g.get(nums[l]);
                if (c > 1) {
                    dup--;
                }
                g.put(nums[l], c - 1);
                cnt--;
                l++;
            }
            int c = g.getOrDefault(nums[i], 0);
            if (c > 0) {
                dup++;
            }
            g.put(nums[i], c + 1);
            ans = Math.max(ans, i - l + 1 - dup);
        }
        return n - ans;
    }
}