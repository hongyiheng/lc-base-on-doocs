class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        ans, exchange, bottle = numBottles, numBottles // numExchange, numBottles % numExchange
        while exchange != 0 or bottle >= numExchange:
            ans += exchange
            bottle += exchange
            exchange = bottle // numExchange
            bottle -= (exchange * numExchange)
        return int(ans)