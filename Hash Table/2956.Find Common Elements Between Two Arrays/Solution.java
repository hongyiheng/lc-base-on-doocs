class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        int[] ans = new int[]{0, 0};
        for (int v : nums1) {
            if (s2.contains(v)) {
                ans[0]++;
            }
        }
        for (int v : nums2) {
            if (s1.contains(v)) {
                ans[1]++;
            }
        }
        return ans;
    }
}