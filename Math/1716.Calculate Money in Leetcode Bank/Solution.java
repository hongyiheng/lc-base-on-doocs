class Solution {
    public int totalMoney(int n) {
        int[] m = new int[]{1, 2, 3, 4, 5, 6, 7};
        int week = n / 7, rest = n % 7;
        int ans = 0;
        while (week-- > 0) {
            for (int i = 0; i < m.length; i++) {
                ans += m[i];
                m[i] += 1;
            }
        }
        for (int i = 0; i < rest; i++) {
            ans += m[i];
        }
        return ans;
    }
}