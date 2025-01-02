class Solution {
    public boolean canAliceWin(int n) {
        int i = 10;
        while (n >= i) {
            n -= i;
            i--;
        }
        return i % 2 == 1;
    }
}