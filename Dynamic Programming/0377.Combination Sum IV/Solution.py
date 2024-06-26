class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        f = [0] * (target + 1)
        f[0] = 1
        for i in range(target + 1):
            for v in nums:
                if i < v:
                    continue
                f[i] += f[i - v]
        return f[target]