class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int n = nums.length, last = lower - 1;
        if (n == 0) {
            String s = getStr(lower - 1, upper + 1);
            if (s != null) {
                ans.add(s);
            }
            return ans;
        }
        for (int i = 0; i < n; i++) {
            String s = getStr(last, nums[i]);
            if (s != null) {
                ans.add(s);
            }
            last = nums[i];
        }
        String s = getStr(last, upper + 1);
        if (s != null) {
            ans.add(s);
        }
        return ans;
    }

    public String getStr(int a, int b) {
        if (b - a <= 1) {
            return null;
        }
        if (b - a == 2) {
            return String.valueOf(a + 1);
        }
        return String.valueOf(a + 1) + "->" + String.valueOf(b - 1);
    }
}
