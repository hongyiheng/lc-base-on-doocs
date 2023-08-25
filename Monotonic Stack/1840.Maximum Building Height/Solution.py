class Solution:
    def maxBuilding(self, n: int, restrictions: List[List[int]]) -> int:
        restrictions.sort(key=lambda x:x[0])
        q = deque()
        for i, v in restrictions:
            while q and q[-1][1] > v and q[-1][1] - v > i - q[-1][0]:
                q.pop()
            q.append([i, v])
        ans = 0
        x, y = 1, 0
        while x < n:
            while q and q[0][0] <= x:
                q.popleft()
            nx = q[0][0] if q else n
            ny = min(nx - x + y, q[0][1]) if q else inf
            l, r = 0, nx - x + y
            while l < r:
                mid = (l + r + 1) >> 1
                if mid - y + mid - ny > nx - x:
                    r = mid - 1
                else:
                    l = mid
            ans = max(ans, l)
            x, y = nx, ny
        return ans