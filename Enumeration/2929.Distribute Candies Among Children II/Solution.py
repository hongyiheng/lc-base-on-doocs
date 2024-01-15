class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        start = n - 2 * limit if n >= 2 * limit else 0
        l, r = 0, min(n, limit)
        while l < r:
            mid = (l + r) >> 1
            if n - start - mid > limit:
                l = mid + 1
            else:
                r = mid
        ans = 0
        for i in range(start, min(n, limit) + 1):
            r = min(n - i, limit)
            while l and n - i - l + 1 <= limit:
                l -= 1
            ans += r - l + 1
        return ans