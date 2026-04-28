class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        q = []
        for row in grid:
            for v in row:
                q.append(v)
        q.sort()
        mid = q[len(q) // 2]
        ans = 0
        for v in q:
            if abs(v - mid) % x:
                return -1
            ans += abs(v - mid) // x
        return ans