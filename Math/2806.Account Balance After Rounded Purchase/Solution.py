class Solution:
    def accountBalanceAfterPurchase(self, purchaseAmount: int) -> int:
        ans = 100 - purchaseAmount // 10 * 10
        return ans - (10 if purchaseAmount % 10 >= 5 else 0)