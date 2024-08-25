class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        @cache
        def dfs(msk, s):
            nonlocal t
            if msk == (1 << len(nums)) - 1:
                return True
            for i, v in enumerate(nums):
                if msk >> i & 1:
                    continue
                if s + v > t:
                    break
                if dfs(msk | 1 << i, (s + v) % t):
                    return True
            return False

        s = sum(nums)
        if s % k != 0:
            return False
        t = s // k
        nums.sort()
        return dfs(0, 0)
