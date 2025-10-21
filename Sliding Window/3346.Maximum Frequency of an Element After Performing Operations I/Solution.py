class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        cnt = Counter(nums)
        ans = s = 0
        for x in range(min(nums), max(nums) + k + 1):
            s += cnt.get(x, 0)
            s -= cnt.get(x - 2 * k - 1, 0)
            ans = max(ans, min(s - cnt[x - k], numOperations) + cnt[x - k])
        return ans
