class Solution:
    def maxPoints(self, grid: List[List[int]], queries: List[int]) -> List[int]:
        m, n = len(grid), len(grid[0])
        arr = []
        q = []
        heapq.heappush(q, [grid[0][0], 0, 0])
        vis = [[False] * n for _ in range(m)]
        vis[0][0] = True
        cur = grid[0][0] + 1
        cnt = 0
        while q:
            v, x, y = heapq.heappop(q)
            if cur <= v:
                arr.append([cur, cnt])
                cur = v + 1
            cnt += 1
            for d in [[0, -1], [-1, 0], [1, 0], [0, 1]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if vis[nx][ny]:
                    continue
                vis[nx][ny] = True
                heapq.heappush(q, [grid[nx][ny], nx, ny])
        arr.append([cur, cnt])
        ans = []
        for v in queries:
            l, r = 0, len(arr) - 1
            while l < r:
                mid = (l + r + 1) >> 1
                if arr[mid][0] > v:
                    r = mid - 1
                else:
                    l = mid
            ans.append(arr[r][1] if v >= arr[r][0] else 0)
        return ans