class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                s.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = 0, r = s.size() - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (s.get(mid) < i) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int diff = Math.abs(i - s.get(l));
            if (l > 0) {
                diff = Math.min(Math.abs(i - s.get(l - 1)), diff);
            }
            if (diff <= k) {
                ans.add(i);
            }
        }
        return ans;
    }
}