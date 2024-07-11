class Solution:
    def incremovableSubarrayCount(self, nums: List[int]) -> int:
        def search(x, v):
            l, r = 0, x
            while l < r:
                mid = (l + r + 1) >> 1
                if nums[mid] < v:
                    l = mid
                else:
                    r = mid - 1
            return r + 1 if nums[r] < v else 0

        n = len(nums)
        l, r = 0, n - 1
        while l + 1 < n and nums[l] < nums[l + 1]:
            l += 1
        if l == n - 1:
            return (n + 1) * n // 2
        while r - 1 >= 0 and nums[r - 1] < nums[r]:
            r -= 1
        ans = l + 2
        for i in range(r, n):
            ans += search(l, nums[i]) + 1
        return ans