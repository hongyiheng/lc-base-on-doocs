class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans = 0
        mi = -inf
        for v in nums:
            v = min(max(v - k, mi + 1), v + k)
            if v > mi:
                ans += 1
                mi = v
        return ans