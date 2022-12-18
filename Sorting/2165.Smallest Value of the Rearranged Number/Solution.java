class Solution {
    public long smallestNumber(long num) {
        String s = String.valueOf(num);
        boolean ne = false;
        if (num < 0) {
            ne = true;
            s = s.substring(1);
        }
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        long ans = 0;
        if (ne) {
            for (int i = 9; i >= 0; i--) {
                while (cnt[i]-- > 0) {
                    ans = ans * 10 + i;
                }
            }
        } else {
            for (int i = 1; i < 10; i++) {
                if (cnt[i]-- > 0) {
                    ans = i;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                while (cnt[i]-- > 0) {
                    ans = ans * 10 + i;
                }
            }
        }
        return ne ? -ans : ans;
    }
}