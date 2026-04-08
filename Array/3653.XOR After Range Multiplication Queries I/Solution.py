class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        mod = int(1e9 + 7)
        for l, r, k, v in queries:
            for i in range(l, r + 1, k):
                nums[i] = nums[i] * v % mod
        ans = 0
        for x in nums:
            ans ^= x
        return ans
