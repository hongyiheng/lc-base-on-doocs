class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        ans = []
        cnt = 1
        for i, v in enumerate(nums):
            if i > 0 and nums[i - 1] + 1 == v:
                cnt += 1
            else:
                cnt = 1
            if i >= k - 1:
                ans.append(v if cnt >= k else -1)
        return ans