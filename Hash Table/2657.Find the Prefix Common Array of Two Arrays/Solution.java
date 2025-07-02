class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long p = 0, q = 0;
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int x = A[i], y = B[i];
            p |= 1L << x;
            q |= 1L << y;
            ans[i] = Long.bitCount(p & q);
        }
        return ans;
    }
}