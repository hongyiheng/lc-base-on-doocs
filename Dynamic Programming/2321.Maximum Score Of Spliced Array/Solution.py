class Solution:
    def maximumsSplicedArray(self, nums1: List[int], nums2: List[int]) -> int:
        def get_max(nums1, nums2):
            s = diff = mx = 0
            for a, b in zip(nums1, nums2):
                s += a
                diff = max(diff + b - a, 0)
                mx = max(mx, diff)
            return s + mx

        return max(get_max(nums1, nums2), get_max(nums2, nums1))