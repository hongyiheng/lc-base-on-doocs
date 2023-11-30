class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        if (n == 1) {
            return derived[0] == 0;
        }
        int f1 = 0, f2 = 1;
        for (int i = 0; i < n - 1; i++) {
            if (derived[i] == 1) {
                f1 ^= 1;
                f2 ^= 1;
            }
        }
        return (f1 ^ 0) == derived[n - 1] || (f2 ^ 1) == derived[n - 1];
    }
}