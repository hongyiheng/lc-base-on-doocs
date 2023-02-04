class Solution:
    def getMaximumConsecutive(self, coins: List[int]) -> int:
        ans = 1
        coins.sort()
        for v in coins:
            if v > ans:
                break
            ans += v
        return ans