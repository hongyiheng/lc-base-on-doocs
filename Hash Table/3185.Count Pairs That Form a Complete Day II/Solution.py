class Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        cnt = [0] * 24
        ans = 0
        for v in hours:
            ans += cnt[(24 - v % 24) % 24]
            cnt[v % 24] += 1
        return ans
