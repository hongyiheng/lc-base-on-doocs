class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        s1 = s2 = 0
        cnt1 = cnt2 = 0
        for v in nums1:
            s1 += v
            if v == 0:
                cnt1 += 1
        for v in nums2:
            s2 += v
            if v == 0:
                cnt2 += 1
        if (cnt1 == 0 and s1 < s2 + cnt2) or (cnt2 == 0 and s1 + cnt1 > s2):
            return -1
        return max(s1 + cnt1, s2 + cnt2)