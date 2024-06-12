class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int ans = 100 - purchaseAmount / 10 * 10;
        return ans - (purchaseAmount % 10 >= 5 ? 10 : 0);
    }
}