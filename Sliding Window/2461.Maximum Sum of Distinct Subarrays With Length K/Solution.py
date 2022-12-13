class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        l = r = ans = cur = 0
        mp = dict()
        while r < n:
            while mp.get(nums[r], 0) or r - l + 1 > k:
                mp[nums[l]] -= 1
                cur -= nums[l]
                l += 1
            mp[nums[r]] = 1
            cur += nums[r]
            if r - l + 1 == k:
                ans = max(cur, ans)
            r += 1
        return ans
