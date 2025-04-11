class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i < high + 1; i++) {
            char[] cs = String.valueOf(i).toCharArray();
            int n = cs.length;
            if (n % 2 != 0) {
                continue;
            }
            int a = 0, b = 0;
            for (int j = 0; j < n / 2; j++) {
                a += cs[j] - '0';
                b += cs[j + n / 2] - '0';
            }
            if (a == b) {
                ans++;
            }
        }
        return ans;
    }
}