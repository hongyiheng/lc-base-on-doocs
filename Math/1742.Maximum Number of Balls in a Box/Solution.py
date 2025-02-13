class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        cnt = dict()
        ans = 0
        for i in range(lowLimit, highLimit + 1):
            cur, k = i, 0
            while cur:
                k += cur % 10
                cur //= 10
            cnt[k] = cnt.get(k, 0) + 1
            ans = max(ans, cnt[k])
        return ans

