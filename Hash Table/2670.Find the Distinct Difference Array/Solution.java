class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int[] ans = new int[n];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            s.add(v);
            int c = cnt.getOrDefault(v, 0);
            if (c == 1) {
                cnt.remove(v);
            } else {
                cnt.put(v, c - 1);
            }
            ans[i] = s.size() - cnt.keySet().size();
        }
        return ans;
    }
}