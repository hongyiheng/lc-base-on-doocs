class Solution:
    def findLHS(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        ans, last = 0, -inf
        for k in sorted(cnt.keys()):
            if k - last == 1:
                ans = max(ans, cnt[k] + cnt[k - 1])
            last = k
        return ans

