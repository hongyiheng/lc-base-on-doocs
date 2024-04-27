class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        up, down = list(), list()
        ans = 0
        for v in nums:
            if up and up[-1] >= v:
                up.clear()
            if down and down[-1] <= v:
                down.clear()
            up.append(v)
            down.append(v)
            ans = max(ans, len(up), len(down))
        return ans

