class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        ban = set(banned)
        ans, cur = 0, 1
        while maxSum > 0:
            while cur in ban:
                cur += 1
            if cur > n or maxSum < cur:
                break
            maxSum -= cur
            ans += 1
            cur += 1
        return ans

