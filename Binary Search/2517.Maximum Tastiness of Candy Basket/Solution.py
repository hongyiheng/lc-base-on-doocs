class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        def check(x):
            last = price[0]
            cnt = 1
            for i in range(1, len(price)):
                if price[i] - last >= x:
                    cnt += 1
                    last = price[i]
            return cnt >= k

        price.sort()
        l, r = 0, price[-1] - price[0]
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return l
