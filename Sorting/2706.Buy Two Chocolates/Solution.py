class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        prices.sort()
        return money if prices[0] + prices[1] > money else money - prices[0] - prices[1]