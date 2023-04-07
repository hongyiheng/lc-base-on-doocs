class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        cnt = defaultdict(int)
        ans = 0
        for t in time:
            gap = 60 - t % 60
            ans += cnt[0 if gap == 60 else gap]
            cnt[t % 60] += 1
        return ans
