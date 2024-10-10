class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], k: int) -> int:
        ans = 0
        for x in nums1:
            for y in nums2:
                if not x % (y * k):
                    ans += 1
        return ans