class Solution {
    public int nextBeautifulNumber(int n) {
        for (int v = n + 1; v < 0x3f3f3f3f; v++) {
            int[] cnt = new int[10];
            int x = v;
            while (x > 0) {
                cnt[x % 10]++;
                x /= 10;
            }
            boolean bal = true;
            for (int i = 0; i < 10; i++) {
                if (cnt[i] > 0 && cnt[i] != i) {
                    bal = false;
                    break;
                }
            }
            if (bal) {
                return v;
            }
        }
        return -1;
    }
}