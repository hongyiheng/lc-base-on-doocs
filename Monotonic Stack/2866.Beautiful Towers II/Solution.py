class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        n = len(maxHeights)
        q = deque()
        pre = [0] * (n + 1)
        for i, v in enumerate(maxHeights):
            l = r = i
            while q and q[-1][1] > v:
                l, lv = q.pop()
                pre[i + 1] -= lv * (r - l)
                r = l
            pre[i + 1] += pre[i] + (i - l + 1) * v
            q.append([l, v])

        q = deque()
        tail = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            v = maxHeights[i]
            l = r = i
            while q and q[0][1] > v:
                r, rv = q.popleft()
                tail[i] -= rv * (r - l)
                l = r
            tail[i] += tail[i + 1] + (r - i + 1) * v
            q.appendleft([r, v])

        ans = 0
        for i in range(n):
            ans = max(ans, pre[i] + tail[i])
        return ans