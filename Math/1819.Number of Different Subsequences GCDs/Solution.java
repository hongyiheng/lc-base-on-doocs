class Solution {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int n = nums.length;
        int mx = 0;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            s.add(nums[i]);
        }
        int ans = s.size();
        for (int i = 1; i < (mx + 1) / 2; i++) {
            if (s.contains(i)) {
                continue;
            }
            int g = 0;
            for (int j = i * 2; j < mx + 1; j += i) {
                if (!s.contains(j)) {
                    continue;
                }
                g = gcd(g, j);
                if (g == i) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}