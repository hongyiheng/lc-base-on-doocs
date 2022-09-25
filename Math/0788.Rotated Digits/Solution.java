class Solution {
    public int rotatedDigits(int n) {
        Set<Integer> nums = new HashSet<>(), valid = new HashSet<>();
        for (int v : new int[]{0, 1, 2, 5, 6, 8, 9}) {
            nums.add(v);
        }
        for (int v : new int[]{2, 5, 6, 9}) {
            valid.add(v);
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            int cur = i;
            boolean flag = false;
            while (cur > 0) {
                if (!nums.contains(cur % 10)) {
                    break;
                }
                if (valid.contains(cur % 10)) {
                    flag = true;
                }
                cur /= 10;
            }
            if (cur <= 0 && flag) {
                ans++;
            }
        }
        return ans;
    }
}
