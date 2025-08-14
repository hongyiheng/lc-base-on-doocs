class Solution {
    public boolean checkPowersOfThree(int n) {
        for (int i = 0; i < 1 << 15; i++) {
            int v = 0;
            for (int j = 0; j < 15; j++) {
                if ((i >> j & 1) == 1) {
                    v += Math.pow(3, j);
                    if (v > n) {
                        break;
                    }
                }
            }
            if (v == n) {
                return true;
            }
        }
        return false;
    }
}