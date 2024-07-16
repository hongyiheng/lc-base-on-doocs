class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s1, s2 = set(nums1), set(nums2)
        ans = [0, 0]
        for v in nums1:
            if v in s2:
                ans[0] += 1
        for v in nums2:
            if v in s1:
                ans[1] += 1
        return ans