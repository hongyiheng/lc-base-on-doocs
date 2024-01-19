class Solution:
    def minimumTime(self, nums1: List[int], nums2: List[int], x: int) -> int:
        q = [(a, b) for a, b in zip(nums1, nums2)]
        q.sort(key=lambda x: x[1])
        n = len(nums1)
        f = [0] * (n + 1)
        for i in range(n):
            a, b = q[i]
            for j in range(i + 1, 0, -1):
                f[j] = max(f[j], f[j - 1] + a + b * j)
        s1, s2 = sum(nums1), sum(nums2)
        for i in range(n + 1):
            if s1 + s2 * i - f[i] <= x:
                return i
        return -1