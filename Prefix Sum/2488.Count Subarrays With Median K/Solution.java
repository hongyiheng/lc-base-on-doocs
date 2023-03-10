class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length, pos = 0, s = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                pos = i;
                break;
            }
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        for (int i = pos + 1; i < n; i++) {
            s += nums[i] > k ? 1 : -1;
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        int ans = cnt.get(0) + cnt.getOrDefault(1, 0);
        s = 0;
        for (int i = pos - 1; i > -1; i--) {
            s += nums[i] > k ? 1 : -1;
            ans += cnt.getOrDefault(-s, 0);
            ans += cnt.getOrDefault(-s + 1, 0);
        }
        return ans;
    }
}
