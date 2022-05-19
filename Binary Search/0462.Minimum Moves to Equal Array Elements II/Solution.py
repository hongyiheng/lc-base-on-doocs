class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        def get_diff(x):
            nonlocal nums
            cnt = 0
            for v in nums:
                cnt += abs(v - x)
            return cnt

        left, right = min(nums), max(nums)
        while left < right:
            mid = (left + right) >> 1
            cnt1 = get_diff(mid)
            cnt2 = get_diff(mid + 1)
            if cnt2 < cnt1:
                left = mid + 1
            else:
                right = mid
        return get_diff(left)