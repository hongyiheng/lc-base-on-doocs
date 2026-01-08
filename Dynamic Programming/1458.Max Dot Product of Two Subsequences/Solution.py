class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        @cache
        def f(i, j):
            nonlocal m, n
            if i >= m or j >= n:
                return 0
            ans = nums1[i] * nums2[j] + f(i + 1, j + 1)
            ans = max(ans, f(i + 1, j))
            ans = max(ans, f(i, j + 1))
            ans = max(ans, f(i + 1, j + 1))
            return ans

        m, n = len(nums1), len(nums2)
        all_pos1 = len([v for v in nums1 if v > 0]) == m
        all_neg1 = len([v for v in nums1 if v < 0]) == m
        all_pos2 = len([v for v in nums2 if v > 0]) == n
        all_neg2 = len([v for v in nums2 if v < 0]) == n
        if (all_pos1 and all_neg2) or (all_neg1 and all_pos2):
            return min([abs(v) for v in nums1]) * min([abs(v) for v in nums2]) * -1
        return f(0, 0)