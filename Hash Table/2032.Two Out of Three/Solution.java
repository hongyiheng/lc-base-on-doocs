class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();
        for (int v : nums1) {
            s1.add(v);
        }
        for (int v : nums2) {
            s2.add(v);
        }
        for (int v : nums3) {
            s3.add(v);
        }
        Set<Integer> ans = new HashSet<>();
        for (int i : s1) {
            if (s2.contains(i) || s3.contains(i)) {
                ans.add(i);
            }
        }
        for (int i : s2) {
            if (s3.contains(i)) {
                ans.add(i);
            }
        }
        return new ArrayList<>(ans);
    }
}
