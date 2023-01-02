class Solution:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        buy, sell = list(), list()
        for v, c, t in orders:
            if t == 0:
                while sell and sell[0][0] <= v:
                    vs, cs = heapq.heappop(sell)
                    c -= cs
                    if c <= 0:
                        if c < 0:
                            heapq.heappush(sell, (vs, -c))
                        break
                if c > 0:
                    heapq.heappush(buy, (-v, c))
            else:
                while buy and -buy[0][0] >= v:
                    vb, cb = heapq.heappop(buy)
                    c -= cb
                    if c <= 0:
                        if c < 0:
                            heapq.heappush(buy, (vb, -c))
                        break
                if c > 0:
                    heapq.heappush(sell, (v, c))
        ans = 0
        while buy:
            ans += buy.pop()[1]
        while sell:
            ans += sell.pop()[1]
        return ans % int(1e9 + 7)