class Solution {
    public String losingPlayer(int x, int y) {
        int ans = Math.min(x, y / 4);
        return ans % 2 == 1 ? "Alice" : "Bob";
    }
}