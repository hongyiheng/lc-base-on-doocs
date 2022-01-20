class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] m = new int[]{0, 0, 0};
        for (int stone : stones) {
            m[stone % 3]++;
        }
        if (m[0] % 2 == 0) {
            return m[1] > 0 && m[2] > 0;
        }
        return Math.abs(m[1] - m[2]) > 2;
    }
}