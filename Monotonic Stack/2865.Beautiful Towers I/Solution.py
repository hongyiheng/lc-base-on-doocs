class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        n = len(maxHeights)
        pre, suf = [0] * n, [0] * n
        q = deque()
        for i, v in enumerate(maxHeights):
            while q and q[-1][0] > v:
                q.pop()
            s, last = 0, -1
            for h, j in q:
                s += (j - last) * h
                last = j
            q.append([v, i])
            pre[i] = s + (i - last) * v
        q.clear()
        for i in range(n - 1, -1, -1):
            v = maxHeights[i]
            while q and q[-1][0] > v:
                q.pop()
            s, last = 0, n
            for h, j in q:
                s += (last - j) * h
                last = j
            q.append([v, i])
            suf[i] = s + (last - i) * v
        ans = max(suf[0], pre[-1])
        for i in range(n - 1):
            ans = max(ans, pre[i] + suf[i + 1])
        return ans
