class Solution:
    def minimumAddedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        def check(x):
            i = d = 0
            while i < len(nums2) and d <= 2:
                if nums1[i + d] + x != nums2[i]:
                    d += 1
                else:
                    i += 1
            return i == len(nums2)

        nums1.sort()
        nums2.sort()
        xs = [nums2[0] - nums1[i] for i in range(3)]
        xs.sort()
        for x in xs:
            if check(x):
                return x
        return 0
