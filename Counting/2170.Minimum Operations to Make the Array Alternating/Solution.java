class Solution {
    public int minimumOperations(int[] nums) {
        int[] a = getMaxCnt(nums, 0, -1);
        int[] b = getMaxCnt(nums, 1, a[0]);
        int[] c = getMaxCnt(nums, 1, -1);
        int[] d = getMaxCnt(nums, 0, c[0]);
        return nums.length - Math.max(a[1] + b[1], c[1] + d[1]);
    }

    public int[] getMaxCnt(int[] nums, int idx, int x) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[2];
        for (int i = idx; i < nums.length; i += 2) {
            if (nums[i] == x) {
                continue;
            }
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            if (mp.get(nums[i]) > ans[1]) {
                ans[1] = mp.get(nums[i]);
                ans[0] = nums[i];
            }
        }
        return ans;
    }
}