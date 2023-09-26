class Solution {
    public int passThePillow(int n, int time) {
        time %= (2 * n - 2);
        return time <= n - 1 ? time + 1 : n - (time - (n - 1));
    }
}