class Solution:
    def splitArraySameAverage(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1:
            return False
        m, s = n // 2, sum(nums)
        for i in range(n):
            nums[i] = nums[i] * n - s
        vis = set()
        for i in range(1, 1 << m):
            ss = 0
            for j in range(m):
                if (1 << j) & i:
                    ss += nums[j]
            if ss == 0:
                return True
            vis.add(ss)
        for i in range(1, 1 << (n - m)):
            ss = 0
            for j in range(n - m):
                if (1 << j) & i:
                    ss += nums[j + m]
            if ss == 0 or (i != (1 << n - m) - 1 and -ss in vis):
                return True
        return False
