class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] cs = new int[5];
        for (char c : suits){
            if (++cs[c - 'a'] == 5) {
                return "Flush";
            }
        }
        int[] rs = new int[14];
        int mx = 0;
        for (int r : ranks) {
            mx = Math.max(mx, ++rs[r]);
        }
        if (mx >= 3) {
            return "Three of a Kind";
        }
        if (mx == 2) {
            return "Pair";
        }
        return "High Card";
    }
}
