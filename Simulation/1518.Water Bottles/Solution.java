class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int exchange = numBottles / numExchange;
        int bottle = numBottles % numExchange;
        while (exchange != 0 || bottle >= numExchange) {
            ans += exchange;
            bottle += exchange;
            exchange = bottle / numExchange;
            bottle -= exchange * numExchange;
        }
        return ans;
    }
}