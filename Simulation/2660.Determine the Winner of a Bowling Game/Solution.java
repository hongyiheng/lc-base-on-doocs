class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int t1 = 0, t2 = 0, d1 = 0, d2 = 0;
        for (int i = 0; i < player1.length; i++) {
            int a = player1[i], b = player2[i];
            t1 += d1 > 0 ? 2 * a : a;
            t2 += d2 > 0 ? 2 * b : b;
            d1 = a == 10 ? 2 : d1 - 1;
            d2 = b == 10 ? 2 : d2 - 1;
        }
        if (t1 == t2) {
            return 0;
        }
        return t1 > t2 ? 1 : 2;
    }
}