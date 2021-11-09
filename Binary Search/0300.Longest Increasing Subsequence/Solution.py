class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        tail = [0] * len(nums)
        res = 0
        for num in nums:
            left, right = 0, res
            while left < right:
                mid = (left + right) >> 1
                if tail[mid] < num:
                    left = mid + 1
                else:
                    right = mid
            tail[left] = num
            if left == res:
                res += 1
        return res