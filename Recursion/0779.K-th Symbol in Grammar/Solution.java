class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return k == 1 ? 0 : 1;
        }
        if (k <= (1 << n - 1) / 2) {
            return kthGrammar(n - 1, k);
        }
        return kthGrammar(n - 1, k - (1 << n - 1) / 2) ^ 1;
    }
}
