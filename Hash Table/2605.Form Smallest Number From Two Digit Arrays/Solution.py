class Solution:
    def minNumber(self, nums1: List[int], nums2: List[int]) -> int:
        cnt = [0] * 10
        for v in nums1:
            cnt[v] = 1
        for v in nums2:
            cnt[v] = 3 if cnt[v] else 2
        a = b = 0
        for i, v in enumerate(cnt):
            if v == 3:
                return i
            if v == 1 and not a:
                a = i
            if v == 2 and not b:
                b = i
        return min(a, b) * 10 + max(a, b)