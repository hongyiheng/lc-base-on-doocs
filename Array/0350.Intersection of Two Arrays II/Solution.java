class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt = new int[1010];
        for (int v : nums1) {
            cnt[v]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int v : nums2) {
            if (cnt[v] > 0) {
                ans.add(v);
                cnt[v]--;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}