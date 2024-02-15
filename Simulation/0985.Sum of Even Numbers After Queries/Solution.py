class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        ans = []
        s = 0
        for v in nums:
            if v % 2 == 0:
                s += v
        for v, i in queries:
            if nums[i] % 2 == 0:
                s -= nums[i]
            nums[i] += v
            if nums[i] % 2 == 0:
                s += nums[i]
            ans.append(s)
        return ans