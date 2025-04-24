class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int t = (int)Arrays.stream(nums).distinct().count();
        int l = 0, ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int r = 0; r < n; r++) {
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            while (cnt.keySet().size() == t) {
                ans += n - r;
                int x = cnt.get(nums[l]);
                if (x == 1) {
                    cnt.remove(nums[l]);
                } else {
                    cnt.put(nums[l], x - 1);
                }
                l++;
            }
        }
        return ans;
    }
}