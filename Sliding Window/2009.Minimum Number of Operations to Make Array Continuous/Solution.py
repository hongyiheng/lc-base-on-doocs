class Solution:
    def minOperations(self, nums: List[int]) -> int:
        nums.sort()
        g = defaultdict(int)
        n = len(nums)
        ans = dup = cnt = 0
        l = 0
        for i in range(n):
            while nums[i] - nums[l] >= n:
                if g[nums[l]] > 1:
                    dup -= 1
                g[nums[l]] -= 1
                cnt -= 1
                l += 1
            if g[nums[i]]:
                dup += 1
            cnt += 1
            g[nums[i]] += 1
            ans = max(ans, i - l + 1 - dup)
        return n - ans