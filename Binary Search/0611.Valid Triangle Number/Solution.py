class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        n, ans = len(nums), 0
        for i in range(n):
            for j in range(i + 1, n):
                left, right = j + 1, n - 1
                if left >= n:
                    continue
                while left < right:
                    mid = (left + right + 1) >> 1
                    if nums[i] + nums[j] > nums[mid]:
                        left = mid
                    else:
                        right = mid - 1
                if nums[i] + nums[j] > nums[left]:
                    ans += left - j
        return ans