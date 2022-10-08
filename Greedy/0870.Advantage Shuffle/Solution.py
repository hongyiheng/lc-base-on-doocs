class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        arr = [[v, i] for i, v in enumerate(nums2)]
        arr.sort(key=lambda x: -x[0])
        n = len(nums1)
        ans = [0] * n
        l, r = 0, n - 1
        for v, i in arr:
            if v < nums1[r]:
                ans[i] = nums1[r]
                r -= 1
            else:
                ans[i] = nums1[l]
                l += 1
        return ans
