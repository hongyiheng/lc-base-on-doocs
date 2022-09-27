class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length, m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int left = l[i], right = r[i];
            Set<Integer> s = new HashSet();
            int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
            for (int j = left; j <= right; j++) {
                s.add(nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                minVal = Math.min(minVal, nums[j]);
            }
            if ((maxVal - minVal) % (right - left) != 0) {
                ans.add(false);
                continue;
            }
            int k = (maxVal - minVal) / (right - left);
            boolean flag = true;
            while (minVal < maxVal) {
                if (!s.contains(minVal + k)) {
                    flag = false;
                    break;
                }
                minVal += k;
            }
            ans.add(flag);
        }
        return ans;
    }
}
