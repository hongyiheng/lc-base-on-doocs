class Solution:
    def longestAlternatingSubarray(self, nums: List[int], threshold: int) -> int:
        ans = l = 0
        n = len(nums)
        while l < n:
            if nums[l] % 2 or nums[l] > threshold:
                l += 1
                continue
            r = l + 1
            while r < n:
                if nums[r] > threshold:
                    break
                if nums[r] % 2 == nums[r - 1] % 2:
                    break
                r += 1
            ans = max(ans, r - l)
            l = r
        return ans