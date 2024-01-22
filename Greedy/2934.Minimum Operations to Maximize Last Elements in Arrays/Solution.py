class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int]) -> int:
        def f(nums1, nums2):
            mx_a, mx_b = nums1[-1], nums2[-1]
            ans = 0
            for a, b in zip(nums1, nums2):
                if a <= mx_a and b <= mx_b:
                    continue
                if b <= mx_a and a <= mx_b:
                    ans += 1
                    continue
                return -1
            return ans

        ans1 = f(nums1, nums2)
        nums1[-1], nums2[-1] = nums2[-1], nums1[-1]
        ans2 = f(nums1, nums2)
        if ans2 == -1:
            return ans1
        if ans1 == -1:
            return ans2 + 1
        return min(ans1, ans2 + 1)