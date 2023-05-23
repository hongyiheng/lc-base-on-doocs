class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        q = [[a, b] for a, b in zip(values, labels)]
        q.sort(key=lambda x:-x[0])
        ans = 0
        cnt = defaultdict(int)
        for a, b in q:
            if numWanted <= 0:
                break
            if cnt[b] < useLimit:
                cnt[b] += 1
                numWanted -= 1
                ans += a
        return ans
