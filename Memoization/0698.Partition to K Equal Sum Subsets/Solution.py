class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        n, t = len(nums), 0
        nums.sort()
        for v in nums:
            t += v
        if t % k != 0:
            return False
        t //= k

        @cache
        def dfs(state, cur):
            if state == (1 << n) - 1:
                return True
            for i in range(n):
                if (1 << i) & state != 0:
                    continue
                if cur + nums[i] > t:
                    break
                if dfs(state | (1 << i), (cur + nums[i]) % t):
                    return True
            return False

        return dfs(0, 0)