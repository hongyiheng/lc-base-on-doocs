class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> s = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != key) {
                continue;
            }
            for (int j = Math.max(0, i - k); j < Math.min(n, i + k + 1); j++) {
                s.add(j);
            }
        }
        List<Integer> ans = new ArrayList<>(s);
        Collections.sort(ans);
        return ans;
    }
}