class Solution {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int countBeautifulPairs(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = Integer.valueOf(String.valueOf(nums[i]).substring(0, 1));
                int b = nums[j] % 10;
                if (gcd(a, b) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}