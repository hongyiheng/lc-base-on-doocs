class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ids = [0] * 32
        ans = [0] * n
        for i in range(n - 1, -1, -1):
            r = i
            for j in range(32):
                if nums[i] & (1 << j):
                    ids[j] = i
                r = max(r, ids[j])
            ans[i] = r - i + 1
        return ans
