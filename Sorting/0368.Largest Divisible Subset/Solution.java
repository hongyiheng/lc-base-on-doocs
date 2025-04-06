class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n], p = new int[n];
        Arrays.fill(p, -1);
        int mxIdx = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            for (int j = 0; j < i; j++) {
                if (v % nums[j] == 0 && f[j] > f[i]) {
                    f[i] = f[j];
                    p[i] = j;
                }
            }
            f[i]++;
            if (f[i] > f[mxIdx]) {
                mxIdx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (mxIdx >= 0) {
            ans.add(nums[mxIdx]);
            mxIdx = p[mxIdx];
        }
        return ans;
    }
}