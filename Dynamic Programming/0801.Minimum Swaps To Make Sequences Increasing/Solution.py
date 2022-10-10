class Solution:
    def minSwap(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        no_sawp, swap = 0, 1
        for i in range(1, n):
            a = b = float('inf')
            if nums1[i - 1] < nums1[i] and nums2[i - 1] < nums2[i]:
                a = no_sawp
                b = swap + 1
            if nums1[i - 1] < nums2[i] and nums2[i - 1] < nums1[i]:
                a, b = min(a, swap), min(b, no_sawp + 1)
            no_sawp, swap = a, b
        return min(no_sawp, swap)
