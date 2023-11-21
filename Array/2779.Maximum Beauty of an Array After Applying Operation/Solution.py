class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        M = 100010
        cnt = [0] * M
        for v in nums:
            cnt[max(v - k, 0)] += 1
            cnt[min(v + k + 1, M - 1)] -= 1
        ans = s = 0
        for v in cnt:
            s += v
            ans = max(ans, s)
        return ans