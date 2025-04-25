class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + (1 if nums[i] % modulo == k else 0)

        g = defaultdict(int)
        ans = 0
        for v in pre:
            if v >= k:
                ans += g[(v - k) % modulo]
            g[v % modulo] += 1
        return ans
