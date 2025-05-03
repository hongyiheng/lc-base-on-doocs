class Solution {

    public int f(int x, int[] tops, int[] bottoms) {
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < tops.length; i++) {
            int t = tops[i], b = bottoms[i];
            if (t == x && b == x) {
                continue;
            }
            if (t == x) {
                ans2++;
            } else if (b == x) {
                ans1++;
            } else {
                return -1;
            }
        }
        return Math.min(ans1, ans2);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans1 = f(tops[0], tops, bottoms);
        int ans2 = f(bottoms[0], tops, bottoms);
        if (ans1 == -1) {
            return ans2;
        } else if (ans2 == -1) {
            return ans1;
        }
        return Math.min(ans1, ans2);
    }
}