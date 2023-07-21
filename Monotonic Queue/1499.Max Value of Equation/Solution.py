class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        n = len(points)
        q = deque()
        ans = -inf
        idx = 0
        for i, v in enumerate(points):
            x, y = v
            idx = max(idx, i + 1)
            while q and q[0][0] <= x:
                q.popleft()
            while idx < n and points[idx][0] - x <= k:
                while q and q[-1][0] + q[-1][1] < points[idx][0] + points[idx][1]:
                    q.pop()
                q.append(points[idx])
                idx += 1
            if q:
                ans = max(ans, q[0][0] - x + q[0][1] + y)
        return ans