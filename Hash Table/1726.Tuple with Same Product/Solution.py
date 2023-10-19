class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        n = len(nums)
        g = defaultdict(int)
        ans = 0
        for i in range(n):
            for j in range(i + 1, n):
                ans += g[nums[i] * nums[j]] * 8
                g[nums[i] * nums[j]] += 1
        return ans