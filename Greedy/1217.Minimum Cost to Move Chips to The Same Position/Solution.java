class Solution {
    public int minCostToMoveChips(int[] position) {
        int a = 0, b = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                a++;
            } else {
                b++;
            }
        }
        return Math.min(a, b);
    }
}