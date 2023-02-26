class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 2:
            return n
        mx = mi = nums[0]
        mx_idx = mi_idx = 0
        for i, v in enumerate(nums):
            if v > mx:
                mx = v
                mx_idx = i
            if v < mi:
                mi = v
                mi_idx = i
        ans = max(mi_idx, mx_idx) + 1
        ans = min(ans, max(n - mi_idx, n - mx_idx))
        ans = min(ans, min(mi_idx, mx_idx) + 1 + n - max(mi_idx, mx_idx))
        return ans