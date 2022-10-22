class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums2[i], k -> new ArrayList<>()).add(i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = mp.get(nums1[i]).remove(0);
        }
        return ans;
    }
}
