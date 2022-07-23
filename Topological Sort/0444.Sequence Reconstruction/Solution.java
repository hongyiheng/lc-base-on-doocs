class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Set<Integer> s = new HashSet<>();
        for (List<Integer> v : sequences) {
            for (int i = 1; i < v.size(); i++) {
                s.add((v.get(i - 1) << 14) | v.get(i));
            }
        }
        for (int i = 1; i < nums.length; i++) {
            int t = (nums[i - 1] << 14) | nums[i];
            if (!s.contains(t)) {
                return false;
            }
        }
        return true;
    }
}