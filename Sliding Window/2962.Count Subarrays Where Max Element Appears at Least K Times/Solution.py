class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        mx = max(nums)
        l = r = cnt = ans = 0
        while r < len(nums):
            cnt += nums[r] == mx
            while cnt >= k:
                cnt -= nums[l] == mx
                l += 1
            ans += l
            r += 1
        return ans