class Solution {
    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            int mx = 0;
            for (int j = i + 1; j < n; j++) {
                if (cs[j] > cs[i]) {
                    if (mx == 0 || cs[mx] <= cs[j]) {
                        mx = j;
                    }
                }
            }
            if (mx != 0) {
                char tmp = cs[i];
                cs[i] = cs[mx];
                cs[mx] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(cs));
    }
}