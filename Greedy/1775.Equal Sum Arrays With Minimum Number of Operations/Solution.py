class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        if n > m * 6 or n * 6 < m:
            return -1
        s1, s2 = sum(nums1), sum(nums2)
        if s1 < s2:
            return self.minOperations(nums2, nums1)

        mp = dict()
        for v in nums1:
            mp[v - 1] = mp.get(v - 1, 0) + 1
        for v in nums2:
            mp[6 - v] = mp.get(6 - v, 0) + 1
        ans, t = 0, s1 - s2
        for i in range(5, 0, -1):
            if t <= 0:
                break
            num = mp.get(i, 0)
            if num * i >= t:
                ans += (t + i - 1) // i
            else:
                ans += num
            t -= num * i
        return ans
