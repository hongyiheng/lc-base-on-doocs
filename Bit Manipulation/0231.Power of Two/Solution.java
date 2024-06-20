class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        return (n & -n) > 0 && n == (n & -n);
    }
}