class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int], k: int) -> int:
        if k == 0:
            return 0 if nums1 == nums2 else -1
        diff = ans = 0
        for a, b in zip(nums1, nums2):
            if abs(a - b) % k:
                return -1
            if a - b > 0:
                ans += (a - b) // k
            diff += a - b
        return ans if diff == 0 else -1
