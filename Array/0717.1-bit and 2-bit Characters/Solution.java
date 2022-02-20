class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n) {
            if (bits[i] == 1) {
                i++;
            } else if (bits[i] == 0 && i == n - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}