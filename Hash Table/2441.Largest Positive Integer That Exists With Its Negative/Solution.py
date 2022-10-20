class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        s = set()
        for v in nums:
            if v < 0:
                s.add(v)
        ans = -1
        for v in nums:
            if -v in s:
                ans = max(ans, v)
        return ans
