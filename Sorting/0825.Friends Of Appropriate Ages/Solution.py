class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        ans, n = 0, len(ages)
        ages.sort()

        def check(x, y):
            if y <= 0.5 * x + 7:
                return False
            if y > x:
                return False
            if y > 100 and x < 100:
                return False
            return True

        l, r = 0, 0
        for k in range(n):
            r = max(k, r)
            while l < k and not check(ages[l], ages[k]):
                l += 1
            while r < n and check(ages[r], ages[k]):
                r += 1
            if r > l:
                ans += r - l - 1
        return ans
