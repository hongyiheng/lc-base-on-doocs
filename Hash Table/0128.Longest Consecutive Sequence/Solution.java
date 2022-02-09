class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            int left = num;
            int right = num;
            if (!set.contains(left - 1)) {
                while(set.contains(right + 1)) {
                    ++right;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}