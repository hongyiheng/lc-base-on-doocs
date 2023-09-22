class Solution:
    def findScore(self, nums: List[int]) -> int:
        q = [(v, i) for i, v in enumerate(nums)]
        q.sort(key=lambda x: (x[0], x[1]))
        n, ans = len(nums), 0
        used = [False] * n
        for v, i in q:
            if used[i]:
                continue
            for j in range(max(0, i - 1), min(i + 2, n)):
                used[j] = True
            ans += v
        return ans