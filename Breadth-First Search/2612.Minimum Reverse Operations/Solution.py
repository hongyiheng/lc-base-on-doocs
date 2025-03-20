class Solution:
    def minReverseOperations(self, n: int, p: int, banned: List[int], k: int) -> List[int]:
        f = [-1] * n
        f[p] = 0
        q = [[0, p]]
        while q:
            w, pos = heapq.heappop(q)
            for np in range(max(0, pos - k + 1), min(n, pos + k)):
                if (f[np] != -1 and f[np] <= f[pos] + 1) or np in banned:
                    continue
                if (k - abs(np - pos) - 1) % 2:
                    continue
                t = (k - abs(np - pos) - 1) // 2
                if 0 <= min(np, pos) - t and max(np, pos) + t < n:
                    f[np] = f[pos] + 1
                    heapq.heappush(q, [f[np], np])
        return f