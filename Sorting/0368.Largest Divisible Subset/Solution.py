class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        n = len(nums)
        f, p = [0] * n, [-1] * n
        mx_i = 0
        for i, v in enumerate(nums):
            for j in range(i):
                if v % nums[j] == 0 and f[j] > f[i]:
                    f[i] = f[j]
                    p[i] = j
            f[i] += 1
            if f[i] > f[mx_i]:
                mx_i = i

        ans = []
        i = mx_i
        while i >= 0:
            ans.append(nums[i])
            i = p[i]
        return ans