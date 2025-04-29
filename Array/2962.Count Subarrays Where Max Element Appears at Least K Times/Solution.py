class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        mx = max(nums)
        ans = cnt = l = 0
        for i, v in enumerate(nums):
            if v == mx:
                cnt += 1
            while cnt >= k:
                if nums[l] == mx:
                    cnt -= 1
                l += 1
            ans += lgit
        return ans